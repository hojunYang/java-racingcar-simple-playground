package movingCarGame.domain;

import java.util.Random;

public class Car {
    private static final int AT_LEAST_VALUE = 4;
    private static final int RANDOM_RANGE = 10;

    private String name;
    private int distance;
    private Random random;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        random = new Random();
    }

    public Car(String name, Random random) {
        this.name = name;
        this.distance = 0;
        this.random = random;
    }

    private int randomInt(int range) { return random.nextInt(range); }

    public void move() {
        if(randomInt(RANDOM_RANGE) >= AT_LEAST_VALUE) {
            addDistance(1);
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
