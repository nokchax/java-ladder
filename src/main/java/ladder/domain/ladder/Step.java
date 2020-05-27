package ladder.domain.ladder;

import ladder.domain.init.LadderInitInfo;
import ladder.domain.ladder.footstep.FootStepCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 사다리 한단
public class Step {
    private final List<Column> columns;

    private Step(final LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);
        FootStepCreateStrategy footStepCreateStrategy = ladderInitInfo.getFootStepCreateStrategy();

        columns = new ArrayList<>(ladderInitInfo.playerCount());
        columns.add(Column.init(footStepCreateStrategy));

        Stream.generate(() -> createNextColumn(footStepCreateStrategy))
                .limit(ladderInitInfo.playerCount() - 2) //remove first and last
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

    public List<Boolean> toFootSteps() {
        return columns.stream()
                .map(Column::toRightFootStep)
                .collect(Collectors.toList());
    }

    private Column createNextColumn(final FootStepCreateStrategy footStepCreateStrategy) {
        return getLastColumn().next(footStepCreateStrategy);
    }

    private Column createEndColumn() {
        return getLastColumn().last();
    }

    private Column getLastColumn() {
        return columns.get(columns.size() - 1);
    }
}
