package ladder.domain.ladder;

import ladder.domain.ladder.TakeLadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 타기 결과 포지션을 매칭해주는 클래스 테스트")
class TakeLadderResultTest {

    @Test
    @DisplayName("초기화")
    void init() {
        assertThatCode(() -> TakeLadderResult.init(Arrays.asList(1, 2, 3, 4, 5))).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("초기화 실패 : null이거나 빈 경우")
    void initFail(final List<Integer> matchResults) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> TakeLadderResult.init(matchResults));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("사다리 타기 결과 매치 실패 : 위치가 사다리의 한계값을 벗어 났을때")
    void matchFail(final TakeLadderResult takeLadderResult, final int startPosition) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> takeLadderResult.getResultPositionOf(startPosition));
    }

    private static Stream<Arguments> matchFail() {
        TakeLadderResult takeLadderResult = TakeLadderResult.init(Arrays.asList(5, 4, 3, 2, 1));

        return Stream.of(
                Arguments.of(takeLadderResult, -1),
                Arguments.of(takeLadderResult, 5)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("사다리 타기 결과 매치 성공")
    void matchSuccess(final TakeLadderResult takeLadderResult, final int startPosition, final int expected) {
        assertThat(takeLadderResult.getResultPositionOf(startPosition)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchSuccess() {
        TakeLadderResult takeLadderResult = TakeLadderResult.init(Arrays.asList(5, 4, 3, 2, 1));

        return Stream.of(
                Arguments.of(takeLadderResult, 0, 5),
                Arguments.of(takeLadderResult, 1, 4),
                Arguments.of(takeLadderResult, 2, 3),
                Arguments.of(takeLadderResult, 3, 2),
                Arguments.of(takeLadderResult, 4, 1)
        );
    }
}