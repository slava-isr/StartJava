package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Scanner;

public class HangmanGame {
    private final String[] WORDS = {"Клавиатура", "Лестница", "Виселица", "Код", "Мармелад", "Градусник", "Магнитофон"};
    private int attempts;
    private String wordMask;
    private char[] wrongLetters;
    private char[] correctLetters;
    private char[] guessedLetters;

    public void start(Scanner sc) {
        initializeGame();
        while (attempts > 0 && !Arrays.equals(correctLetters, guessedLetters)) {
            showStats();
            makeMove(sc);
        }
        endGame();
    }

    private void initializeGame() {
        attempts = 5;
        correctLetters = WORDS[(int) (Math.random() * WORDS.length)].toUpperCase().toCharArray();
        guessedLetters = new char[correctLetters.length];
        Arrays.fill(guessedLetters, '_');
        wordMask = new String(guessedLetters);
        wrongLetters = new char[0];
    }

    private void showStats() {
        switch (attempts) {
            case 0 -> System.out.println("\n" +
                    "  ┌───────┐\n" +
                    "  │       │\n" +
                    "  │     (x_x)\n" +
                    "  │      ⎧│⎫\n" +
                    "  │       │\n" +
                    "  │      / \\\n" +
                    "  │\n" +
                    "──┴────────────");
            case 1 -> System.out.println("\n" +
                    "  ┌───────┐\n" +
                    "  │       │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "──┴────────────");
            case 2 -> System.out.println("\n" +
                    "  ┌───────\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "──┴────────────");
            case 3 -> System.out.println("\n" +
                    "  ┌\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "  │\n" +
                    "──┴────────────");
            case 4 -> System.out.println("\n" +
                    "──┴────────────");
            default -> System.out.println();
        }
        System.out.println("Попыток осталось: " + attempts);
        System.out.println("Ошибочные буквы: " + Arrays.toString(wrongLetters));
        System.out.println("Загадано слово из " + wordMask.length() + " букв: " + wordMask);
    }

    private void makeMove(Scanner sc) {
        char enteredLetter = getValidatedInput(sc);
        boolean isGuessed = updateGuessedLetters(enteredLetter);
        if (!isGuessed) addWrongLetters(enteredLetter);
    }

    private char getValidatedInput(Scanner sc) {
        System.out.print("\nВведите букву: ");
        String input = sc.nextLine().toUpperCase();
        char enteredLetter = input.charAt(0);
        if (input.length() != 1 || enteredLetter < 'А' || enteredLetter > 'Я') {
            System.out.println("Можно ввести только одну букву кириллицы!");
            return getValidatedInput(sc);
        }
        if (isUsedLetter(enteredLetter, wrongLetters) || isUsedLetter(enteredLetter, guessedLetters)) {
            return getValidatedInput(sc);
        }
        return enteredLetter;
    }

    private boolean isUsedLetter(char enteredLetter, char[] usedLetters) {
        for (char usedLetter : usedLetters) {
            if (usedLetter == enteredLetter) {
                System.out.println("Можно вводить только неиспользованные ранее буквы!");
                return true;
            }
        }
        return false;
    }

    private boolean updateGuessedLetters(char enteredLetter) {
        boolean isGuessed = false;
        for (int i = 0; i < correctLetters.length; i++) {
            if (correctLetters[i] == enteredLetter) {
                isGuessed = true;
                guessedLetters[i] = enteredLetter;
                wordMask = new String(guessedLetters);
            }
        }
        adjustAttempts(isGuessed);
        return isGuessed;
    }

    private void adjustAttempts(boolean isGuessed) {
        if (isGuessed && attempts < 5) {
            attempts++;
        } else if (!isGuessed) {
            attempts--;
        }
    }

    private void addWrongLetters(char enteredLetter) {
        wrongLetters = Arrays.copyOf(wrongLetters, wrongLetters.length + 1);
        wrongLetters[wrongLetters.length - 1] = enteredLetter;
    }

    private void endGame() {
        showStats();
        if (attempts == 0) {
            System.out.println("\nК сожалению вы проиграли =(");
        } else {
            System.out.println("\nПоздравляем, вы отгадали слово!");
        }
    }
}