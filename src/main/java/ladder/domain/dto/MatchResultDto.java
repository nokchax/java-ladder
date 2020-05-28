package ladder.domain.dto;

import ladder.util.ObjectUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MatchResultDto {
    private final Map<String, String> playerAndPrize;
    private final List<StepDto> steps;

    private MatchResultDto(final Map<String, String> playerAndPrize, final List<StepDto> steps) {
        ObjectUtil.checkNull(playerAndPrize, steps);

        this.playerAndPrize = playerAndPrize;
        this.steps = steps;
    }

    public static MatchResultDto of(final Map<String, String> playerAndPrize, final List<StepDto> steps) {
        return new MatchResultDto(playerAndPrize, steps);
    }

    public List<String> getPlayers() {
        return new ArrayList<>(playerAndPrize.keySet());
    }

    public List<String> getPrizes() {
        return new ArrayList<>(playerAndPrize.values());
    }

    public List<StepDto> getSteps() {
        return steps;
    }
}
