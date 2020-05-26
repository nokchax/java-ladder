package ladder.domain.ladder;

import ladder.domain.ladder.footstep.FootStepStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ladder.util.Static.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 기둥 테스트")
class ColumnTest {

    @Test
    @DisplayName("사다리 기둥을 초기화 할때는 발판 생성에 대한 전략이 필요하다")
    void init() {
        assertThatCode(() -> Column.init(TRUE_RETURN_STRATEGY))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("기둥의 다음 기둥생성 테스트")
    void next(final Column column, final FootStepStrategy footStepStrategy, final Column expected) {
        assertThat(column.next(footStepStrategy)).isEqualTo(expected);
    }

    private static Stream<Arguments> next() {
        return Stream.of(
                Arguments.of(COLUMN_WITH_RIGHT_FOOTSTEP, TRUE_RETURN_STRATEGY, COLUMN_WITH_LEFT_FOOTSTEP),
                Arguments.of(COLUMN_WITH_RIGHT_FOOTSTEP, FALSE_RETURN_STRATEGY, COLUMN_WITH_LEFT_FOOTSTEP),
                Arguments.of(COLUMN_WITH_LEFT_FOOTSTEP, TRUE_RETURN_STRATEGY, COLUMN_WITH_RIGHT_FOOTSTEP),
                Arguments.of(COLUMN_WITH_LEFT_FOOTSTEP, FALSE_RETURN_STRATEGY, COLUMN_WITHOUT_FOOTSTEP),
                Arguments.of(COLUMN_WITHOUT_FOOTSTEP, TRUE_RETURN_STRATEGY, COLUMN_WITH_RIGHT_FOOTSTEP),
                Arguments.of(COLUMN_WITHOUT_FOOTSTEP, FALSE_RETURN_STRATEGY, COLUMN_WITHOUT_FOOTSTEP)
        );
    }
}