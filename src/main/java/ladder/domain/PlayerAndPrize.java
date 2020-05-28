package ladder.domain;

import ladder.domain.init.PlayerAndPrizeInitInfo;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.util.ObjectUtil;

import java.util.List;

public class PlayerAndPrize {
    private final Players players;
    private final Prizes prizes;

    private PlayerAndPrize(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo) {
        ObjectUtil.checkNull(playerAndPrizeInitInfo, "PlayerAndPrizeInitInfo is null");

        this.players = Players.init(playerAndPrizeInitInfo.getNames());
        this.prizes = Prizes.init(playerAndPrizeInitInfo.getPrizes());
    }

    public static PlayerAndPrize init(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo) {
        return new PlayerAndPrize(playerAndPrizeInitInfo);
    }

    public List<String> getPlayers() {
        return players.getPlayersName();
    }

    public List<String> getPrizes() {
        return prizes.getPrizes();
    }
}
