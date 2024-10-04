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
            game.startGame(sc);
            updateUserAnswer(sc);
        } while ("yes".equals(userAnswer));
        System.out.println("До свидания!");
        sc.close();
    }

    private static void updateUserAnswer(Scanner sc) {
        do {
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            userAnswer = sc.next().toLowerCase();
        } while (!"no".equals(userAnswer) && !"yes".equals(userAnswer));
    }
}