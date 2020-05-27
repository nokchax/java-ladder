package ladder.domain.dto;

import java.util.List;

public class StepDto {
    private final List<Boolean> footSteps;

    private StepDto(final List<Boolean> footSteps) {
        validate(footSteps);

        this.footSteps = footSteps;
    }

    private void validate(List<Boolean> footSteps) {
        if (footSteps == null) {
            throw new IllegalArgumentException("Foot steps are null");
        }
    }

    public static StepDto of(final List<Boolean> footSteps) {
        return new StepDto(footSteps);
    }

    public List<Boolean> getFootSteps() {
        return footSteps;
    }
}
