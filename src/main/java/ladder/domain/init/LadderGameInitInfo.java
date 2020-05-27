package ladder.domain.init;

import ladder.domain.player.Players;

import java.util.List;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final Players players;

    private LadderGameInitInfo(final List<String> names, final int height) {
        this.players = Players.init(names);
        this.ladderInitInfo = LadderInitInfo.init(height, players.getPlayersCount());
    }

    public static LadderGameInitInfo init(final List<String> names, final int height) {
        return new LadderGameInitInfo(names, height);
    }
}
