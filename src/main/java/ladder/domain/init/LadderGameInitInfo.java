package ladder.domain.init;

import ladder.domain.ladder.strategy.LadderInitStrategies;
import ladder.domain.ladder.strategy.LadderInitStrategy;
import ladder.util.ObjectUtil;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final PlayerAndPrizeInitInfo playerAndPrizeInitInfo;

    private LadderGameInitInfo(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo,
                               final LadderInitStrategy ladderInitStrategy) {
        ObjectUtil.checkNull(playerAndPrizeInitInfo, "PlayerAndPrizeInitInfo is null");

        int height = ladderInitStrategy.getLadderHeightStrategy()
                .decideHeight();

        LadderSize ladderSize = LadderSize.init(playerAndPrizeInitInfo.getPlayerCount(), height);
        this.playerAndPrizeInitInfo = playerAndPrizeInitInfo;
        this.ladderInitInfo = LadderInitInfo.init(ladderSize, ladderInitStrategy);
    }

    public static LadderGameInitInfo init(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo,
                                          final LadderInitStrategy ladderInitStrategy) {
        return new LadderGameInitInfo(playerAndPrizeInitInfo, ladderInitStrategy);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public PlayerAndPrizeInitInfo getPlayerAndPrizeInitInfo() {
        return playerAndPrizeInitInfo;
    }
}
