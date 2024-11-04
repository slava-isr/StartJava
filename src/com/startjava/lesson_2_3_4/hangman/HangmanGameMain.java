package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру \"Виселица\"");
        Scanner sc = new Scanner(System.in);
        do {
            new HangmanGame().start(sc);
        } while (promptToContinue(sc));
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static boolean promptToContinue(Scanner sc) {
        String playerAnswer;
        do {
            System.out.print("\nХотите продолжить игру? [yes/no]: ");
            playerAnswer = sc.nextLine().toLowerCase();
        } while (!"no".equals(playerAnswer) && !"yes".equals(playerAnswer));
        return "yes".equals(playerAnswer);
    }
}