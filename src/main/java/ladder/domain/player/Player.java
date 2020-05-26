package ladder.domain.player;

import ladder.util.StringUtil;

public class Player {
    public static final int MAX_LENGTH_OF_PLAYER_NAME = 5;
    private String name;
    //private int idx; //or no

    private Player(final String name) {
        validate(name);

        this.name = name;
    }

    private void validate(final String name) {
        if (StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException("Player name is null or empty");
        }

        if (name.length() > MAX_LENGTH_OF_PLAYER_NAME) {
            throw new IllegalArgumentException("Player name should less than or equal to " + MAX_LENGTH_OF_PLAYER_NAME);
        }
    }

    public static Player init(final String name) {
        return new Player(name);
    }
}
