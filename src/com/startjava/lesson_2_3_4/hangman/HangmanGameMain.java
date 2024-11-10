package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру \"Виселица\"");
        Scanner sc = new Scanner(System.in);
        do {
            new HangmanGame().start(sc);
        } while (promptToContinue("\nХотите продолжить игру? [yes/no]: ", sc));
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static boolean promptToContinue(String message, Scanner sc) {
        System.out.print(message);
        String playerAnswer = sc.nextLine().trim().toLowerCase();
        if ("yes".equals(playerAnswer)) return true;
        if ("no".equals(playerAnswer)) return false;
        return promptToContinue("\nВведите корректный ответ [yes / no]: ", sc);
    }
}