package movingCarGame;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarGame {
    List<Car> cars;
    public CarGame(List<Car> carList) {
        cars = carList;
    }

    public String getStringState() {
        return cars.stream().map(car ->
            car.getName() + " : " + "-".repeat(car.getDistance())
        ).collect(Collectors.joining("\n"));
    }

    public String getStringWinner() {
        int max = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        return cars.stream().filter(car -> car.getDistance() == max)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    public void play() {
        cars.forEach(Car::move);
    }
}
