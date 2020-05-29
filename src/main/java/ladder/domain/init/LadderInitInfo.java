package ladder.domain.init;

import ladder.domain.ladder.strategy.LadderInitStrategies;
import ladder.domain.ladder.strategy.LadderInitStrategy;
import ladder.domain.ladder.strategy.footstep.FootStepCreateStrategy;
import ladder.util.ObjectUtil;

public class LadderInitInfo {
    private final LadderInitStrategy ladderInitStrategy;
    private final LadderSize ladderSize;

    private LadderInitInfo(final LadderSize ladderSize, final LadderInitStrategy ladderInitStrategy) {
        ObjectUtil.checkNull(ladderSize, ladderInitStrategy);

        this.ladderSize = ladderSize;
        this.ladderInitStrategy = ladderInitStrategy;
    }

    public static LadderInitInfo init(final LadderSize ladderSize,
                                      final LadderInitStrategy ladderInitStrategy) {
        return new LadderInitInfo(ladderSize, ladderInitStrategy);
    }

    public static LadderInitInfo init(final LadderSize ladderSize) {
        return init(ladderSize, LadderInitStrategies.DEFAULT);
    }

    public FootStepCreateStrategy getFootStepCreateStrategy() {
        return ladderInitStrategy.getFootStepCreateStrategy();
    }

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public int getLadderWidth() {
        return ladderSize.getWidth();
    }
}
