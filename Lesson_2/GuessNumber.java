public class GuessNumber {

    private Player firstPlayer;
    private Player secondPlayer;
    private int rangeFrom;
    private int rangeTo;
    private int guessNumber;

    public GuessNumber(Player firstPlayer, Player secondPlayer, int rangeFrom, int rangeTo) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public void generateGuessNumber() {
        this.guessNumber = rangeFrom + (int) (Math.random() * (rangeTo - rangeFrom + 1));
        System.out.printf("Компьютер загадал число от %d до %d включительно!%n", rangeFrom, rangeTo);
    }

    public boolean playerTurn(Player player, int playerNumber) {
        player.setNumber(playerNumber);
        if (playerNumber == guessNumber) {
            congratsPlayer(player);
            return true;
        } else {
            giveHint(playerNumber);
            return false;
        }
    }

    public boolean isNumberInRange(int number) {
        return number >= rangeFrom && number <= rangeTo;
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