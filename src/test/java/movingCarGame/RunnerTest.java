package movingCarGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunnerTest {
    @Test
    @DisplayName("입력 값 parsing 테스트")
    void testParseNames() {

        assertThat(Runner.parseNames("a,b"))
                .extracting(Car::getName)
                .containsExactly("a", "b");

        assertThatThrownBy(() -> Runner.parseNames("abcdef,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5자를 넘을 수 없습니다.");

        assertThatThrownBy(() -> Runner.parseNames(",b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 최소 한글자를 넣어야 합니다.");
    }
    @Test
    @DisplayName("반복 횟수 parsing 테스트")
    void testParseCount() {
        assertThat(Runner.parseCount("3"))
                .isEqualTo(3);

        assertThatThrownBy(() -> Runner.parseCount("abcde"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요.");

        assertThatThrownBy(() -> Runner.parseCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");

        assertThatThrownBy(() -> Runner.parseCount("121"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 100 이하로 입력해주세요.");
    }
}
