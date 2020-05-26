package ladder.domain.ladder.footstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("발판 생성 전략 인터페이스 테스트")
class FootStepStrategyTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("생성 가능한지")
    void isGenerable(final FootStepStrategy footStepStrategy, final boolean expected) {
        assertThat(footStepStrategy.isGenerable()).isEqualTo(expected);
    }

    private static Stream<Arguments> isGenerable() {
        return Stream.of(
                Arguments.of((FootStepStrategy)() -> true, true),
                Arguments.of((FootStepStrategy)() -> false, false)
        );
    }

}