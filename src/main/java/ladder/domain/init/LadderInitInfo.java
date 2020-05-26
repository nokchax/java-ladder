package ladder.domain.init;

import ladder.domain.ladder.footstep.FootStepStrategy;
import ladder.domain.ladder.footstep.HalfChanceGenerator;

import java.util.List;

public class LadderInitInfo {
    private FootStepStrategy footStepStrategy = new HalfChanceGenerator();
    private List<String> names;
    private List<String> prizes;
    private int ladderHeight;

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
