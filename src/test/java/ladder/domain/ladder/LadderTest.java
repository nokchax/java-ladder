package ladder.domain.ladder;

import ladder.domain.init.LadderInitInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.util.Static.LADDER_INIT_INFO_WITH_TRUE_STRATEGY;
import static ladder.util.Static.NAMES;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 객체 테스트")
class LadderTest {

    @Test
    @DisplayName("초기화 테스트")
    void init() {
        assertThatCode(() -> Ladder.init(LADDER_INIT_INFO_WITH_TRUE_STRATEGY))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("초기화 실패 : null로 인한 초기화 실패")
    void initFail(final LadderInitInfo ladderInitInfo) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.init(ladderInitInfo));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("초기화 실패 : 사다리 높이가 음수")
    void initFailWithNegativeHeight(final int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.init(LadderInitInfo.init(NAMES, height)));
    }
}