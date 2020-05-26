package ladder.domain.ladder;

import ladder.domain.ladder.footstep.FootStepStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static ladder.util.Static.FALSE_RETURN_STRATEGY;
import static ladder.util.Static.TRUE_RETURN_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("발판 테스트")
class FootStepTest {

    @ParameterizedTest
    @ValueSource(strings = {"LEFT", "RIGHT", "NONE"}) //ciw"Ctrl+r"
    @DisplayName("발판은 없거나 기둥을 기준으로 좌, 우로 나뉜다")
    void type(final String type) {
        assertThatCode(() -> FootStep.valueOf(type)).doesNotThrowAnyException();
        assertThat(FootStep.valueOf(type)).isNotNull();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("첫기둥의 발판은 NONE이거나 RIGHT밖에 안된다.")
    void init(final FootStepStrategy footStepStrategy, final FootStep expected) {
        assertThat(FootStep.init(footStepStrategy)).isEqualTo(expected);
    }

    private static Stream<Arguments> init() {
        return Stream.of(
                Arguments.of(TRUE_RETURN_STRATEGY, FootStep.RIGHT),
                Arguments.of(FALSE_RETURN_STRATEGY, FootStep.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("다음 기둥의 발판은 현재 기준으로 정해진다")
    void next(final FootStep curFootStep, final FootStepStrategy footStepStrategy, final FootStep expected) {
        assertThat(curFootStep.next(footStepStrategy)).isEqualTo(expected);
    }

    private static Stream<Arguments> next() {
        return Stream.of(
                Arguments.of(FootStep.RIGHT, TRUE_RETURN_STRATEGY, FootStep.LEFT),
                Arguments.of(FootStep.RIGHT, FALSE_RETURN_STRATEGY, FootStep.LEFT),
                Arguments.of(FootStep.LEFT, TRUE_RETURN_STRATEGY, FootStep.RIGHT),
                Arguments.of(FootStep.LEFT, FALSE_RETURN_STRATEGY, FootStep.NONE),
                Arguments.of(FootStep.NONE, TRUE_RETURN_STRATEGY, FootStep.RIGHT),
                Arguments.of(FootStep.NONE, FALSE_RETURN_STRATEGY, FootStep.NONE)
        );
    }
}