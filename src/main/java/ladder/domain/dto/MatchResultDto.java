package ladder.domain.dto;

import ladder.util.ObjectUtil;

import java.util.List;

public class MatchResultDto {
    private final List<String> players;
    private final List<StepDto> steps;

    private MatchResultDto(final List<String> playersName, final List<StepDto> steps) {
        ObjectUtil.checkNull(playersName, steps);

        this.players = playersName;
        this.steps = steps;
    }

    public static MatchResultDto of(final List<String> playersName, final List<StepDto> steps) {
        return new MatchResultDto(playersName, steps);
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<StepDto> getSteps() {
        return steps;
    }
}
