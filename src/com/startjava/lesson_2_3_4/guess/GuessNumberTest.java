package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final int MAX_PLAYERS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playerAnswer = "yes";
        launchGame(playerAnswer, sc);
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static void launchGame(String playerAnswer, Scanner sc) {
        while (!"no".equals(playerAnswer)) {
            if ("yes".equals(playerAnswer)) {
                new GuessNumber(createPlayers(sc), 1, 100).start(sc);
                System.out.print("\nХотите продолжить игру? [yes / no]: ");
            } else System.out.print("\nВведите корректный ответ [yes / no]: ");
            playerAnswer = sc.nextLine().trim().toLowerCase();
        }
    }

    private static Player[] createPlayers(Scanner sc) {
        Player[] players = new Player[MAX_PLAYERS];
        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.printf("Введите имя %d-го игрока: ", i + 1);
            players[i] = new Player(sc.nextLine());
        }
        return players;
    }
}