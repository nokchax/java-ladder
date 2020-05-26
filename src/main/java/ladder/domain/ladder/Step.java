package ladder.domain.ladder;

import ladder.domain.init.LadderInitInfo;
import ladder.domain.ladder.footstep.FootStepStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

// 사다리 한단
public class Step {
    private final List<Column> columns;

    private Step(final LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);
        FootStepStrategy footStepStrategy = ladderInitInfo.getFootStepStrategy();

        columns = new ArrayList<>(ladderInitInfo.playerCount());
        columns.add(Column.init(footStepStrategy));

        Stream.generate(() -> createNextColumn(footStepStrategy))
                .limit(ladderInitInfo.getLadderHeight() - 2) //remove first and last
                .forEach(columns::add);

        columns.add(createEndColumn());
    }

    private void validate(LadderInitInfo ladderInitInfo) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new IllegalArgumentException("Init info is null");
        }
    }

    public static Step init(final LadderInitInfo ladderInitInfo) {
        return new Step(ladderInitInfo);
    }

    private Column createNextColumn(final FootStepStrategy footStepStrategy) {
        return getLastColumn().next(footStepStrategy);
    }

    private Column createEndColumn() {
        return getLastColumn().last();
    }

    private Column getLastColumn() {
        return columns.get(columns.size() - 1);
    }
}
