import java.util.Scanner;

public class GuessNumberTest {

    private static String userAnswer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        Player firstPlayer = new Player(sc.nextLine());
        System.out.print("Введите имя второго игрока: ");
        Player secondPlayer = new Player(sc.nextLine());
        GuessNumber game = new GuessNumber(firstPlayer, secondPlayer, 1, 100);
        do {
            startGame(game, sc);
            updateUserAnswer(sc);
        } while ("yes".equals(userAnswer));
        System.out.println("До свидания!");
        sc.close();
    }

    private static void startGame(GuessNumber game, Scanner sc) {
        game.generateGuessNumber();
        while (true) {
            if (executePlayerTurn(game, game.getFirstPlayer(), sc)) break;
            if (executePlayerTurn(game, game.getSecondPlayer(), sc)) break;
        }
    }

    private static boolean executePlayerTurn(GuessNumber game, Player player, Scanner sc) {
        System.out.printf("Сейчас отвечает \"%s\": ", player.getName());
        return game.playerTurn(player, inputNumber(game, sc));
    }

    private static int inputNumber(GuessNumber game, Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (game.isNumberInRange(number)) {
                    return number;
                } else {
                    System.out.printf("Ошибка! Введите число от %d до %d включительно: ",
                            game.getRangeFrom(), game.getRangeTo());
                }
            } else {
                System.out.print("Ошибка! Поддерживаются только числа: ");
                sc.next();
            }
        }
    }

    private static void updateUserAnswer(Scanner sc) {
        do {
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            userAnswer = sc.next().toLowerCase();
        } while (!"no".equals(userAnswer) && !"yes".equals(userAnswer));
    }
}