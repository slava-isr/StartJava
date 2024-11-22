package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру \"Виселица\"");
        Scanner sc = new Scanner(System.in);
        String playerAnswer = "yes";
        launchGame(playerAnswer, sc);
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static void launchGame(String userAnswer, Scanner sc) {
        while (!"no".equals(userAnswer)) {
            if ("yes".equals(userAnswer)) {
                new HangmanGame().start(sc);
                System.out.print("\nХотите продолжить игру? [yes / no]: ");
            } else System.out.print("\nВведите корректный ответ [yes / no]: ");
            userAnswer = sc.nextLine().trim().toLowerCase();
        }
    }
}