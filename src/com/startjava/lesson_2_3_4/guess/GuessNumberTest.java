package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final int MAX_PLAYERS = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String playerAnswer = "yes";
        launchGame(playerAnswer);
        System.out.println("\nДо свидания!");
        SCANNER.close();
    }

    private static void launchGame(String playerAnswer) {
        while (!"no".equals(playerAnswer)) {
            if ("yes".equals(playerAnswer)) {
                new GuessNumber(createPlayers(), 1, 100).start(SCANNER);
                System.out.print("\nХотите продолжить игру? [yes / no]: ");
            } else System.out.print("\nВведите корректный ответ [yes / no]: ");
            playerAnswer = SCANNER.nextLine().trim().toLowerCase();
        }
    }

    private static Player[] createPlayers() {
        Player[] players = new Player[MAX_PLAYERS];
        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.printf("Введите имя %d-го игрока: ", i + 1);
            players[i] = new Player(SCANNER.nextLine());
        }
        return players;
    }
}