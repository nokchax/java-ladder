package ladder;

import java.util.List;

public class LadderGame {
    //ladder
    //players
    //prizes

    private LadderGame(final List<String> names) {

    }

    public static LadderGame init(final List<String> names) {
        return new LadderGame(names);
    }
}
