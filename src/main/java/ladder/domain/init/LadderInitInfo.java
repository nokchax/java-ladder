package ladder.domain.init;

import ladder.domain.ladder.footstep.FootStepStrategy;
import ladder.domain.ladder.footstep.HalfChanceGenerator;

import java.util.List;

public class LadderInitInfo {
    private final FootStepStrategy footStepStrategy;
    private final List<String> names;
    private List<String> prizes;
    private int ladderHeight;

    private LadderInitInfo(final List<String> names, final FootStepStrategy footStepStrategy) {
        this.names = names;
        this.footStepStrategy = footStepStrategy;
    }

    public static LadderInitInfo init(final List<String> names, final FootStepStrategy footStepStrategy) {
        return new LadderInitInfo(names, footStepStrategy);
    }

    public static LadderInitInfo init(final List<String> names) {
        return new LadderInitInfo(names, new HalfChanceGenerator());
    }

    public FootStepStrategy getFootStepStrategy() {
        return footStepStrategy;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getPrizes() {
        return prizes;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public int playerCount() {
        return names.size();
    }
}
