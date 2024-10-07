package com.startjava.lesson_2_3.rps;

import java.util.Random;
import java.util.Scanner;

// Игра Камень-Ножницы-Бумага
public class RpsGameFormatting {

    private static final String ROCK = "✊";
    private static final String SCISSORS = "✌️";
    private static final String PAPER = "✋";

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        String firstPlayerName = inputName(sc);
        String secondPlayerName = inputName(sc);

        // Ход первого игрока
        int position = generatePosition(firstPlayerName, random);
        String firstPlayerSign = defineSign(position);
        showSigns(firstPlayerSign);

        // Ход второго игрока
        position = generatePosition(secondPlayerName, random);
        String secondPlayerSign = defineSign(position);
        showSigns(secondPlayerSign);

        defineWinner(firstPlayerName, firstPlayerSign, secondPlayerName, secondPlayerSign);
    }

    private static String inputName(Scanner sc) {
        System.out.print("Введите имя игрока: ");
        return sc.nextLine();
    }

    private static int generatePosition(String playerName, Random random) {
        System.out.println("Ход " + playerName + ": ");
        return random.nextInt(1, 100);
    }

    private static String defineSign(int position) {
        String sign = ROCK;
        if (position > 66) {
            sign = SCISSORS;
        } else if (position > 33) {
            sign = PAPER;
        }
        return sign;
    }

    private static void showSigns(String sign) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.print(ROCK + "\r");
            Thread.sleep(100);
            System.out.print(SCISSORS + "\r");
            Thread.sleep(100);
            System.out.print(PAPER + "\r");
            Thread.sleep(100);
        }
        System.out.println(sign);
    }

    private static void defineWinner(String firstPlayerName, String firstPlayerSign,
                                     String secondPlayerName, String secondPlayerSign) {
        if (firstPlayerSign.equals(secondPlayerSign)) {
            System.out.println("\nПобедила дружба!");
            return;
        }

        boolean isFirstPlayerWin = (firstPlayerSign.equals(ROCK) && secondPlayerSign.equals(SCISSORS))
                || (firstPlayerSign.equals(SCISSORS) && secondPlayerSign.equals(PAPER))
                || (firstPlayerSign.equals(PAPER) && secondPlayerSign.equals(ROCK));

        if (isFirstPlayerWin) {
            System.out.println("\nПобедил - " + firstPlayerName);
        } else {
            System.out.println("\nПобедил - " + secondPlayerName);
        }
    }
}