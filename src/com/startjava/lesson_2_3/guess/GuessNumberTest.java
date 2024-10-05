package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumberTest {

    private static String playerAnswer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        Player firstPlayer = new Player(sc.nextLine());
        System.out.print("Введите имя второго игрока: ");
        Player secondPlayer = new Player(sc.nextLine());
        GuessNumber game = new GuessNumber(firstPlayer, secondPlayer, 1, 100);
        do {
            game.start(sc);
            inputPlayerAnswer(sc);
        } while ("yes".equals(playerAnswer));
        System.out.println("До свидания!");
        sc.close();
    }

    private static void inputPlayerAnswer(Scanner sc) {
        do {
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            playerAnswer = sc.next().toLowerCase();
        } while (!"no".equals(playerAnswer) && !"yes".equals(playerAnswer));
    }
}