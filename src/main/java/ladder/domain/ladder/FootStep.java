package ladder.domain.ladder;

import ladder.domain.ladder.footstep.FootStepStrategy;

//발판
public enum FootStep {
    LEFT,
    RIGHT,
    NONE;

    public static FootStep init(final FootStepStrategy footStepStrategy) {
        return makeFootStep(footStepStrategy);
    }

    public FootStep next(final FootStepStrategy footStepStrategy) {
        if (this == RIGHT) {
            return LEFT;
        }

        return makeFootStep(footStepStrategy);
    }

    private static FootStep makeFootStep(final FootStepStrategy footStepStrategy) {
        if (footStepStrategy.isGenerable()) {
            return RIGHT;
        }

        return NONE;
    }
}
