package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Scanner;

public class HangmanGame {
    private final String[] hangman = {
            "  ┌───────┐",
            "  │       │\n" +
            "  │     (x_x)",
            "  │      ⎧│⎫",
            "  │       │\n" +
            "  │      / \\",
            "  │\n" +
            "──┴────────────"
    };
    private final String[] words = {"Клавиатура", "Лестница", "Виселица", "Код", "Мармелад", "Градусник", "Магнитофон"};
    private int attempts = hangman.length;
    private String hiddenWord;
    private char[] guessedLetters;
    private StringBuilder wrongLetters;

    public void start(Scanner sc) {
        initGame();
        while (attempts > 0 && !hiddenWord.equals(String.valueOf(guessedLetters))) {
            showStats();
            makeMove(sc);
        }
        endGame();
    }

    private void initGame() {
        hiddenWord = words[(int) (Math.random() * words.length)].toUpperCase();
        wrongLetters = new StringBuilder();
        guessedLetters = new char[hiddenWord.length()];
        Arrays.fill(guessedLetters, '_');
    }

    private void makeMove(Scanner sc) {
        char enteredLetter = getValidatedInput(sc);
        if (!isGuessed(enteredLetter)) {
            attempts--;
            wrongLetters.append(wrongLetters.isEmpty() ? "" : ", ").append(enteredLetter);
        } else if (attempts < hangman.length) {
            attempts++;
        }
    }

    private char getValidatedInput(Scanner sc) {
        System.out.print("\nВведите букву: ");
        char enteredLetter = sc.nextLine().toUpperCase().charAt(0);
        if (enteredLetter < 'А' || enteredLetter > 'Я') {
            System.out.println("Можно ввести только одну букву кириллицы!");
            return getValidatedInput(sc);
        }
        String usedLetters = String.valueOf(guessedLetters) + wrongLetters.toString();
        if (usedLetters.contains(String.valueOf(enteredLetter))) {
            System.out.println("Можно вводить только неиспользованные ранее буквы!");
            return getValidatedInput(sc);
        }
        return enteredLetter;
    }

    private boolean isGuessed(char enteredLetter) {
        boolean isGuessed = false;
        char[] rightLetters = hiddenWord.toCharArray();
        for (int i = 0; i < rightLetters.length; i++) {
            if (rightLetters[i] == enteredLetter) {
                guessedLetters[i] = enteredLetter;
                isGuessed = true;
            }
        }
        return isGuessed;
    }

    private void endGame() {
        showStats();
        System.out.println(attempts == 0 ?
                "\nК сожалению вы проиграли, это слово " + hiddenWord :
                "\nПоздравляем, вы отгадали слово!");
    }

    private void showStats() {
        System.out.println();
        for (int i = attempts; i < hangman.length; i++) {
            System.out.println(hangman[i]);
        }
        System.out.println("Попыток осталось: " + attempts);
        System.out.println("Ошибочные буквы: " + wrongLetters);
        System.out.println("Загадано слово из " + hiddenWord.length() + " букв: " + String.valueOf(guessedLetters));
    }
}