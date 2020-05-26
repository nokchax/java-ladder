package ladder.util;

import ladder.domain.ladder.footstep.FootStepStrategy;

public class Static {
    public static final FootStepStrategy TRUE_RETURN_STRATEGY = () -> true;
    public static final FootStepStrategy FALSE_RETURN_STRATEGY = () -> false;

    private Static() {}
}
