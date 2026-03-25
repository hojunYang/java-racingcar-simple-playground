package movingCarGame.util;

public class FixedRandomGenerator implements RandomGenerator {
    private final int value;

    public FixedRandomGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generateRandomValue(int bound) {
        return value;
    }
}
