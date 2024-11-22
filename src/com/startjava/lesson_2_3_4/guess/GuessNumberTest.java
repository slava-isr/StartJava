package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        Player firstPlayer = new Player(sc.nextLine());
        System.out.print("Введите имя второго игрока: ");
        Player secondPlayer = new Player(sc.nextLine());
        System.out.print("Введите имя третьего игрока: ");
        Player thirdPlayer = new Player(sc.nextLine());
        String playerAnswer = "yes";
        launchGame(playerAnswer, sc, firstPlayer, secondPlayer, thirdPlayer);
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static void launchGame(String playerAnswer, Scanner sc, Player... players) {
        while (!"no".equals(playerAnswer)) {
            if ("yes".equals(playerAnswer)) {
                new GuessNumber(players, 1, 100).start(sc);
                System.out.print("\nХотите продолжить игру? [yes / no]: ");
            } else System.out.print("\nВведите корректный ответ [yes / no]: ");
            playerAnswer = sc.nextLine().trim().toLowerCase();
        }
    }
}