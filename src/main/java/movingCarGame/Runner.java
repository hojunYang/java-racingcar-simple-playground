package movingCarGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_TRY_GAMES = 100;
    static Scanner input = new Scanner(System.in);

    static void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자를 넘을 수 없습니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름의 길이는 최소 한글자를 넣어야 합니다.");
        }
    }

    static List<Car> parseNames(String inputString) {
        List<Car> cars;
        String[] names = inputString.trim().split(",");
        cars = Arrays.stream(names).map(name -> {
            validateName(name);
            return new Car(name);
        }).toList();

        return cars;
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
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    static int parseCount(String inputNumber) {
        int count = parseInt(inputNumber);
        validateCount(count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<Car> cars = parseNames(input.nextLine());
        CarGame game = new CarGame(cars);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = parseCount(input.nextLine());

        System.out.println("실행결과");
        for(int i=0; i < count; i++) {
            game.play();
            System.out.println(game.getStringState());
            System.out.println();
        }

        System.out.println(game.getStringWinner() + "가 최종 우승했습니다.");
    }
}
