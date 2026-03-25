package movingCarGame.domain;

import movingCarGame.util.DefaultRandomGenerator;
import movingCarGame.util.RandomGenerator;

public class Car {
    private static final int MIN_MOVE_CONDITION = 4;
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_STEP = 1;

    private final String name;
    private int distance;
    private final RandomGenerator random;

    public Car(String name) {
        this(name, new DefaultRandomGenerator());
    }

    public Car(String name, RandomGenerator random) {
        this.name = name;
        this.distance = 0;
        this.random = random;
    }

    public void move() {
        if(random.generateRandomValue(RANDOM_BOUND) >= MIN_MOVE_CONDITION) {
            addDistance(MOVE_STEP);
        }
    }

    public void addDistance(int addValue) {
        distance += addValue;
    }
    public String getName() {
        return name;
    }
    public int getDistance() {
        return distance;
    }

}
