package movingCarGame;

import movingCarGame.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import movingCarGame.util.FixedRandomGenerator;

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

    @DisplayName("랜덤값이 3이면 이동하지 않는다")
    @Test
    void testMoveWhenThree() {
        FixedRandomGenerator random = new FixedRandomGenerator(3);
        Car car = new Car("abc", random);
        car.move();

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("랜덤값이 4이면 이동한다")
    @Test
    void testMoveWhenFour() {
        FixedRandomGenerator random = new FixedRandomGenerator(4);
        Car car = new Car("abc", random);
        car.move();

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
