package ladder.domain.dto;

import ladder.util.ObjectUtil;

import java.util.List;

public class LadderDto {
    private final List<String> players;
    private final List<StepDto> steps;
    private final List<String> prizes;

    private LadderDto(final List<String> players, final List<String> prizes, final List<StepDto> steps) {
        ObjectUtil.checkNull(players, prizes, steps);

        this.players = players;
        this.prizes = prizes;
        this.steps = steps;
    }

    public static LadderDto of(final List<String> players, final List<String> prizes, final List<StepDto> steps) {
        return new LadderDto(players, prizes, steps);
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<StepDto> getSteps() {
        return steps;
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
