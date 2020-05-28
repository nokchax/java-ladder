package ladder.domain.prize;

import ladder.util.ObjectUtil;

import java.util.List;

public class Prizes {
    private final List<String> prizes;

    private Prizes(final List<String> prizes) {
        ObjectUtil.checkNull(prizes, "Prizes string list is null");

        this.prizes = prizes;
    }
    public static Prizes init(final List<String> prizes) {
        return new Prizes(prizes);
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
