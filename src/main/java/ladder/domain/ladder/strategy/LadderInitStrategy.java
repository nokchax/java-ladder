package ladder.domain.ladder.strategy;

import ladder.domain.ladder.strategy.footstep.FootStepCreateStrategy;
import ladder.domain.ladder.strategy.ladderheight.LadderHeightStrategy;

public interface LadderInitStrategy {
    FootStepCreateStrategy getFootStepCreateStrategy();
    LadderHeightStrategy getLadderHeightStrategy();
}
