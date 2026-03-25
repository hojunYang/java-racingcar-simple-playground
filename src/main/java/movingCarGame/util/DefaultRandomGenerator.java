package movingCarGame.util;

import java.util.Random;

public class DefaultRandomGenerator implements RandomGenerator {
    private final Random random = new Random();

    @Override
    public int generateRandomValue(int bound) {
        return random.nextInt(bound);
    }
}
