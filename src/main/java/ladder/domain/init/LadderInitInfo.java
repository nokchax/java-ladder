package ladder.domain.init;

import ladder.domain.ladder.footstep.FootStepStrategy;
import ladder.domain.ladder.footstep.HalfChanceGenerator;

import java.util.List;

public class LadderInitInfo {
    private final FootStepStrategy footStepStrategy;
    private final List<String> names;
    private final int ladderHeight;

    private LadderInitInfo(final List<String> names,
                           final int ladderHeight,
                           final FootStepStrategy footStepStrategy) {
        this.names = names;
        this.ladderHeight = ladderHeight;
        this.footStepStrategy = footStepStrategy;
    }

    public static LadderInitInfo init(final List<String> names,
                                      final int ladderHeight,
                                      final FootStepStrategy footStepStrategy) {
        return new LadderInitInfo(names, ladderHeight, footStepStrategy);
    }

    public static LadderInitInfo init(final List<String> names, final int ladderHeight) {
        return new LadderInitInfo(names, ladderHeight, new HalfChanceGenerator());
    }

    public FootStepStrategy getFootStepStrategy() {
        return footStepStrategy;
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
