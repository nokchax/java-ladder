package ladder.domain.match;

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
class MatchResultTest {

    @Test
    @DisplayName("초기화")
    void init() {
        assertThatCode(() -> MatchResult.init(Arrays.asList(1, 2, 3, 4, 5))).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("초기화 실패 : null이거나 빈 경우")
    void initFail(final List<Integer> matchResults) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MatchResult.init(matchResults));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("사다리 타기 결과 매치 실패 : 위치가 사다리의 한계값을 벗어 났을때")
    void matchFail(final MatchResult matchResult, final int startPosition) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> matchResult.getResultPositionOf(startPosition));
    }

    private static Stream<Arguments> matchFail() {
        MatchResult matchResult = MatchResult.init(Arrays.asList(5, 4, 3, 2, 1));

        return Stream.of(
                Arguments.of(matchResult, -1),
                Arguments.of(matchResult, 5)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("사다리 타기 결과 매치 성공")
    void matchSuccess(final MatchResult matchResult, final int startPosition, final int expected) {
        assertThat(matchResult.getResultPositionOf(startPosition)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchSuccess() {
        MatchResult matchResult = MatchResult.init(Arrays.asList(5, 4, 3, 2, 1));

        return Stream.of(
                Arguments.of(matchResult, 0, 5),
                Arguments.of(matchResult, 1, 4),
                Arguments.of(matchResult, 2, 3),
                Arguments.of(matchResult, 3, 2),
                Arguments.of(matchResult, 4, 1)
        );
    }
}