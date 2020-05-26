package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

}