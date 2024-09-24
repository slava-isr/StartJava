public class MyFirstGame {
    public static void main(String[] args) {
        int guessNum = 14;
        int userNum = 25;
        while (guessNum != userNum) {
            if (guessNum < userNum) {
                System.out.println(userNum + " больше того, что загадал компьютер");
                userNum--;
            } else if (guessNum > userNum) {
                System.out.println(userNum + " меньше того, что загадал компьютер");
                userNum++;
            }
        }
        System.out.println("Вы победили!");
    }
}