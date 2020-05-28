package ladder.domain.init;

import ladder.util.ObjectUtil;

import java.util.List;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final PlayerAndPrizeInitInfo playerAndPrizeInitInfo;

    private LadderGameInitInfo(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo, final int height) {
        ObjectUtil.checkNull(playerAndPrizeInitInfo, "PlayerAndPrize init info is null");

        this.playerAndPrizeInitInfo = playerAndPrizeInitInfo;
        this.ladderInitInfo = LadderInitInfo.init(height, playerAndPrizeInitInfo.playerCount());
    }

    public static LadderGameInitInfo init(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo, final int height) {
        return new LadderGameInitInfo(playerAndPrizeInitInfo, height);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public List<String> getNames() {
        return playerAndPrizeInitInfo.getNames();
    }

    public List<String>  getPrizes() {
        return playerAndPrizeInitInfo.getPrizes();
    }
}
