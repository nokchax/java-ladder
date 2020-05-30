package ladder.domain.ladder.strategy;

import ladder.domain.ladder.strategy.footstep.FootStepCreateStrategy;
import ladder.domain.ladder.strategy.footstep.RandomChanceStrategy;
import ladder.domain.ladder.strategy.ladderheight.LadderHeightStrategy;
import ladder.domain.ladder.strategy.ladderheight.RandomHeightStrategy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ladder.domain.ladder.strategy.LadderInitStrategies.Type.*;

public enum LadderInitStrategies implements LadderInitStrategy {
    HARD(
            HARD_TYPE.type,
            RandomChanceStrategy.init(HARD_TYPE.standard),
            RandomHeightStrategy.init(HARD_TYPE.base, HARD_TYPE.range)
    ),
    MEDIUM(
            MEDIUM_TYPE.type,
            RandomChanceStrategy.init(MEDIUM_TYPE.standard),
            RandomHeightStrategy.init(MEDIUM_TYPE.base, MEDIUM_TYPE.range)
    ),
    EASY(
            EASY_TYPE.type,
            RandomChanceStrategy.init(EASY_TYPE.standard),
            RandomHeightStrategy.init(EASY_TYPE.base, EASY_TYPE.range)
    );

    private final String type;
    private final FootStepCreateStrategy footStepCreateStrategy;
    private final LadderHeightStrategy ladderHeightStrategy;

    public static final LadderInitStrategies DEFAULT = MEDIUM;
    private static final Map<String, LadderInitStrategies> STRATEGIES =
            Arrays.stream(values())
                    .collect(Collectors.toMap(LadderInitStrategies::getType, Function.identity()));

    LadderInitStrategies(final String type,
                         final FootStepCreateStrategy footStepCreateStrategy,
                         final LadderHeightStrategy ladderHeightStrategy) {
        this.type = type;
        this.footStepCreateStrategy = footStepCreateStrategy;
        this.ladderHeightStrategy = ladderHeightStrategy;
    }

    public static LadderInitStrategies of(final String type) {
        if (!STRATEGIES.containsKey(type)) {
            throw new IllegalArgumentException("Unknown type : " + type);
        }

        return STRATEGIES.get(type);
    }

    private String getType() {
        return type;
    }

    @Override
    public boolean isGenerable() {
        return footStepCreateStrategy.isGenerable();
    }

    @Override
    public int decideHeight() {
        return ladderHeightStrategy.decideHeight();
    }

    static class Type {
        static final Type HARD_TYPE = new Type("상", 7, 4, 2);
        static final Type MEDIUM_TYPE = new Type("중", 5, 2, 5);
        static final Type EASY_TYPE = new Type("하", 2, 3, 7);

        String type;
        int base;
        int range;
        int standard;

        public Type(final String type, final int base, final int range, final int standard) {
            this.type = type;
            this.base = base;
            this.range = range;
            this.standard = standard;
        }
    }
}
