package ladder.domain.ladder.footstep;

import java.util.concurrent.ThreadLocalRandom;

public class HalfChanceGenerator implements FootStepStrategy {

    @Override
    public boolean isGenerable() {
        return ThreadLocalRandom.current()
                .nextBoolean();
    }
}
