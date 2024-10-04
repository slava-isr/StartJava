import java.util.Scanner;

public class GuessNumber {

    private final Player firstPlayer;
    private final Player secondPlayer;
    private final int rangeFrom;
    private final int rangeTo;
    private int guessNumber;

    public GuessNumber(Player firstPlayer, Player secondPlayer, int rangeFrom, int rangeTo) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public void startGame(Scanner sc) {
        generateGuessNumber();
        while (true) {
            if (executePlayerTurn(firstPlayer, sc)) break;
            if (executePlayerTurn(secondPlayer, sc)) break;
        }
    }

    private void generateGuessNumber() {
        this.guessNumber = rangeFrom + (int) (Math.random() * (rangeTo - rangeFrom + 1));
        System.out.printf("Компьютер загадал число от %d до %d включительно!%n", rangeFrom, rangeTo);
    }

    private boolean executePlayerTurn(Player player, Scanner sc) {
        System.out.printf("Сейчас отвечает \"%s\": ", player.getName());
        return playerTurn(player, inputNumber(sc));
    }

    private int inputNumber(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (number >= rangeFrom && number <= rangeTo) {
                    return number;
                } else {
                    System.out.printf("Ошибка! Введите число от %d до %d включительно: ", rangeFrom, rangeTo);
                }
            } else {
                System.out.print("Ошибка! Поддерживаются только числа: ");
                sc.next();
            }
        }
    }

    private boolean playerTurn(Player player, int playerNumber) {
        player.setNumber(playerNumber);
        if (playerNumber == guessNumber) {
            congratsPlayer(player);
            return true;
        } else {
            giveHint(playerNumber);
            return false;
        }
    }

    private void congratsPlayer(Player player) {
        System.out.println("Поздравляем! " + player.getName() + " победил!");
    }

    private void giveHint(int playerNumber) {
        System.out.print("Не угадал... введённое число ");
        if (playerNumber > guessNumber) {
            System.out.println("больше загаданного");
        } else {
            System.out.println("меньше загаданного");
        }
    }
}