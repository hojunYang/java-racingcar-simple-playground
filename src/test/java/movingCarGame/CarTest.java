package movingCarGame;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {

    @Test
    @DisplayName("자동차 이름을 제대로 받아올 수 있는지 테스트")
    public void testGetCarName() {
        Car car = new Car("abc");
        assertThat(car.getName())
                .isEqualTo("abc");

    }

    @Test
    @DisplayName("자동차 거리 조회 기능 테스트")
    public void testGetDistance() {
        Car car = new Car("abc");

        assertThat(car.getDistance())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 거리 추가 기능 테스트")
    public void testAddDistance() {
        Car car = new Car("abc");
        car.addDistance(3);

        assertThat(car.getDistance())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("move 메소드 기능 테스트")
    public void testMove() {
        for (int i = 0; i < 100; i ++ ) {
            Random mockRandom = mock(Random.class);
            when(mockRandom.nextInt(10)).thenReturn(i % 10);

            Car car = new Car("abc", mockRandom);
            car.move();

            int expected = 0;
            if (i % 10 >= 4) {
                expected = 1;
            }

            assertThat(car.getDistance())
                    .isEqualTo(expected);
        }
    }
}
