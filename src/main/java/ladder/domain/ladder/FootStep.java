package ladder.domain.ladder;

import ladder.domain.ladder.footstep.FootStepStrategy;

import java.util.Objects;

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

    public FootStep last() {
        if (this == RIGHT) {
            return LEFT;
        }

        return NONE;
    }

    private static FootStep makeFootStep(final FootStepStrategy footStepStrategy) {
        validate(footStepStrategy);
        if (footStepStrategy.isGenerable()) {
            return RIGHT;
        }

        return NONE;
    }

    private static void validate(final FootStepStrategy footStepStrategy) {
        if (Objects.isNull(footStepStrategy)) {
            throw new IllegalArgumentException("FootStepStrategy can't be a null");
        }
    }
}
