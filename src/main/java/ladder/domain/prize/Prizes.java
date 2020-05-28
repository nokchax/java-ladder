package ladder.domain.prize;

import ladder.util.ObjectUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(final List<String> prizes) {
        ObjectUtil.checkNull(prizes, "Prizes string list is null");

        this.prizes = prizes.stream()
                .map(Prize::init)
                .collect(Collectors.toList());
    }

    public static Prizes init(final List<String> prizes) {
        return new Prizes(prizes);
    }

    public List<String> getPrizes() {
        return prizes.stream()
                .map(Prize::getPrize)
                .collect(Collectors.toList());
    }
}
