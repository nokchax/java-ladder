package ladder.domain.init;

import ladder.domain.player.Players;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final Players players;

    private LadderGameInitInfo(final LadderInitInfo ladderInitInfo, final Players players) {
        this.ladderInitInfo = ladderInitInfo;
        this.players = players;
    }
}
