package movingCarGame;

import java.util.Arrays;
import java.util.List;
import movingCarGame.domain.Car;
import movingCarGame.domain.CarGame;
import movingCarGame.view.InputView;
import movingCarGame.view.OutputView;

public class Application {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_TRY_GAMES = 100;
    static InputView iv = new InputView();
    static OutputView ov = new OutputView();

    static void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자를 넘을 수 없습니다.");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름의 길이는 최소 한글자를 넣어야 합니다.");
        }
    }

    static List<Car> parseNames(String inputString) {
        String[] names = inputString.split(",");

        return Arrays.stream(names).map(name -> {
            validateName(name);
            return new Car(name);
        }).toList();
    }

    static int parseInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    static void validateCount(int count) {
        if (count > MAX_TRY_GAMES) {
            throw new IllegalArgumentException("시도 횟수는 " + MAX_TRY_GAMES + " 이하로 입력해주세요.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    static int parseCount(String inputNumber) {
        int count = parseInt(inputNumber);
        validateCount(count);
        return count;
    }

    public static void main(String[] args) {
        String input = iv.readCarNames();
        List<Car> cars = parseNames(input);
        CarGame game = new CarGame(cars);

        input = iv.readTryCount();
        int count = parseCount(input);

        ov.printResult();
        for (int i = 0; i < count; i++) {
            game.play();
            ov.printRoundResult(game.getCars());
        }
        ov.printFinalWinner(game.getWinners());
    }
}
