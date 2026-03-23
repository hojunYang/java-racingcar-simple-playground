package movingCarGame;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarGameTest {

    @Test
    @DisplayName("play 실행 시 모든 자동차의 move 호출 테스트")
    void testPlay() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(10)).thenReturn(5);

        Car a = new Car("a", mockRandom);
        Car b = new Car("b", mockRandom);

        CarGame game = new CarGame(List.of(a, b));
        game.play();

        assertThat(a.getDistance()).isEqualTo(1);
        assertThat(b.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 출력 테스트")
    void testPrintState() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(10)).thenReturn(5);

        Car a = new Car("a", mockRandom);
        Car b = new Car("b", mockRandom);

        CarGame game = new CarGame(List.of(a, b));
        game.play();

        String output = game.getStringState();

        assertThat(output).contains("a : -\nb : -");
    }

    @Test
    @DisplayName("게임 출력 테스트")
    void testPrintWinning() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(10)).thenReturn(5);

        Car a = new Car("a", mockRandom);
        Car b = new Car("b", mockRandom);

        CarGame game = new CarGame(List.of(a, b));
        game.play();

        String output = game.getStringWinner();

        assertThat(output).contains("a,b");
    }
}