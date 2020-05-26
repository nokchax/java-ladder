package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 테스트")
public class LadderGameTest {
    private static final List<String> NAMES = Arrays.asList("name1", "name2", "name3", "name4", "name5");

    @Test
    @DisplayName("초기화 : 사람 이름 리스트를 받아 초기화 한다")
    void init() {
        assertThatCode(() -> LadderGame.init(NAMES)).doesNotThrowAnyException();
    }




}
