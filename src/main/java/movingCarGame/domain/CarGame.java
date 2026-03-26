package movingCarGame.domain;

import java.util.List;

public class CarGame {
    private final List<Car> cars;

    public CarGame(List<Car> carList) {
        cars = carList;
    }

    public List<Car> getWinners() {
        int max = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == max)
                .toList();
    }

    public void play() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}
