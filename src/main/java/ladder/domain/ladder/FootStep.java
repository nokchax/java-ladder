package ladder.domain.ladder;

import ladder.domain.ladder.footstep.FootStepCreateStrategy;
import ladder.util.ObjectUtil;

import java.util.Objects;
import java.util.function.Function;

//발판
public enum FootStep {
    LEFT(x -> x - 1),
    RIGHT(x -> x + 1),
    NONE(x -> x);

    FootStep(final Function<Integer, Integer> mover) {
        this.mover = mover;
    }

    private Function<Integer, Integer> mover;

    public static FootStep init(final FootStepCreateStrategy footStepCreateStrategy) {
        return makeFootStep(footStepCreateStrategy);
    }

    public FootStep next(final FootStepCreateStrategy footStepCreateStrategy) {
        if (this == RIGHT) {
            return LEFT;
        }

        return makeFootStep(footStepCreateStrategy);
    }

    public FootStep last() {
        if (this == RIGHT) {
            return LEFT;
        }

        return NONE;
    }

    private static FootStep makeFootStep(final FootStepCreateStrategy footStepCreateStrategy) {
        validate(footStepCreateStrategy);
        if (footStepCreateStrategy.isGenerable()) {
            return RIGHT;
        }

        return NONE;
    }

    private static void validate(final FootStepCreateStrategy footStepCreateStrategy) {
        ObjectUtil.checkNull(footStepCreateStrategy, "FootStepStrategy can't be a null");
    }

    public Integer move(final int index) {
        return mover.apply(index);
    }
}
