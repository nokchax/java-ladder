package ladder.util;

import ladder.domain.ladder.Column;
import ladder.domain.ladder.footstep.FootStepStrategy;

public class Static {
    public static final FootStepStrategy TRUE_RETURN_STRATEGY = () -> true;
    public static final FootStepStrategy FALSE_RETURN_STRATEGY = () -> false;

    public static final Column COLUMN_WITH_RIGHT_FOOTSTEP = Column.init(TRUE_RETURN_STRATEGY);
    public static final Column COLUMN_WITH_LEFT_FOOTSTEP = COLUMN_WITH_RIGHT_FOOTSTEP.next(TRUE_RETURN_STRATEGY);
    public static final Column COLUMN_WITHOUT_FOOTSTEP = Column.init(FALSE_RETURN_STRATEGY);

    private Static() {}
}
