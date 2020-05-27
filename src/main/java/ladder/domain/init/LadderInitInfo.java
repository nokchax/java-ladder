package ladder.domain.init;

import ladder.domain.ladder.footstep.FootStepCreateStrategy;
import ladder.domain.ladder.footstep.HalfChanceGenerator;

import java.util.List;

public class LadderInitInfo {
    private final FootStepCreateStrategy footStepCreateStrategy;
    private final List<String> names;
    private final int ladderHeight;

    private LadderInitInfo(final List<String> names,
                           final int ladderHeight,
                           final FootStepCreateStrategy footStepCreateStrategy) {
        this.names = names;
        this.ladderHeight = ladderHeight;
        this.footStepCreateStrategy = footStepCreateStrategy;
    }

    public static LadderInitInfo init(final List<String> names,
                                      final int ladderHeight,
                                      final FootStepCreateStrategy footStepCreateStrategy) {
        return new LadderInitInfo(names, ladderHeight, footStepCreateStrategy);
    }

    public static LadderInitInfo init(final List<String> names, final int ladderHeight) {
        return new LadderInitInfo(names, ladderHeight, new HalfChanceGenerator());
    }

    public FootStepCreateStrategy getFootStepCreateStrategy() {
        return footStepCreateStrategy;
    }

    public List<String> getNames() {
        return names;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public int playerCount() {
        return names.size();
    }
}
