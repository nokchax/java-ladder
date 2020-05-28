package ladder.domain.ladder;

import ladder.domain.init.LadderInitInfo;
import ladder.domain.ladder.footstep.FootStepCreateStrategy;
import ladder.util.ObjectUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 사다리 한단
public class Step {
    public static final int MINIMUM_LADDER_WIDTH = 1;

    private final List<Column> columns;

    private Step(final LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);

        columns = new ArrayList<>(ladderInitInfo.getLadderWidth());
        createHead(ladderInitInfo);
        createMid(ladderInitInfo);
        createTail(ladderInitInfo);
    }

    private void createTail(final LadderInitInfo ladderInitInfo) {
        if (ladderInitInfo.getLadderWidth() > MINIMUM_LADDER_WIDTH) {
            columns.add(createEndColumn());
        }
    }

    private void createMid(final LadderInitInfo ladderInitInfo) {
        if(ladderInitInfo.getLadderWidth() < MINIMUM_LADDER_WIDTH + 1) {
            return;
        }

        Stream.generate(() -> createNextColumn(ladderInitInfo.getFootStepCreateStrategy()))
                .limit(ladderInitInfo.getLadderWidth() - 2) //add except first and last column
                .forEach(columns::add);
    }

    private void createHead(final LadderInitInfo ladderInitInfo) {
        if (ladderInitInfo.getLadderWidth() == MINIMUM_LADDER_WIDTH) {
            columns.add(Column.init(() -> false));
            return;
        }

        columns.add(Column.init(ladderInitInfo.getFootStepCreateStrategy()));
    }

    private void validate(final LadderInitInfo ladderInitInfo) {
        ObjectUtil.checkNull(ladderInitInfo, "Init info is null");

        if (ladderInitInfo.getLadderWidth() < MINIMUM_LADDER_WIDTH) {
            throw new IllegalArgumentException("Ladder width must larger or equal to " + MINIMUM_LADDER_WIDTH);
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
