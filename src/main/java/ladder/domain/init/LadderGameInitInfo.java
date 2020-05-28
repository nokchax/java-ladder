package ladder.domain.init;

import ladder.util.ObjectUtil;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final PlayerAndPrizeInitInfo playerAndPrizeInitInfo;

    private LadderGameInitInfo(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo, final int height) {
        ObjectUtil.checkNull(playerAndPrizeInitInfo, "PlayerAndPrizeInitInfo is null");

        this.playerAndPrizeInitInfo = playerAndPrizeInitInfo;
        this.ladderInitInfo = LadderInitInfo.init(height, playerAndPrizeInitInfo.getPlayerCount());
    }

    public static LadderGameInitInfo init(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo, final int height) {
        return new LadderGameInitInfo(playerAndPrizeInitInfo, height);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public PlayerAndPrizeInitInfo getPlayerAndPrizeInitInfo() {
        return playerAndPrizeInitInfo;
    }
}
