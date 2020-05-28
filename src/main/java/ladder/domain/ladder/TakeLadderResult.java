package ladder.domain.ladder;

import ladder.util.ObjectUtil;

import java.util.List;

public class TakeLadderResult {
    private static final int ZERO = 0;

    private final List<Integer> matchPositions;

    private TakeLadderResult(final List<Integer> matchPositions) {
        validate(matchPositions);

        this.matchPositions = matchPositions;
    }

    private void validate(final List<Integer> matchPositions) {
        ObjectUtil.checkNull(matchPositions, "MatchPositions is null");

        if (matchPositions.isEmpty()) {
            throw new IllegalArgumentException("Match result's size is zero");
        }
    }

    public static TakeLadderResult init(final List<Integer> matchPositions) {
        return new TakeLadderResult(matchPositions);
    }

    public int getResultPositionOf(final int startPosition) {
        verifyRange(startPosition);

        return matchPositions.get(startPosition);
    }

    private void verifyRange(final int startPosition) {
        if (startPosition < ZERO || startPosition >= matchPositions.size()) {
            throw new IllegalArgumentException("Start position stray ladder width");
        }
    }
}
