package ru.topjava.lesson1;

import java.util.Random;

public class RpsGameFormatting {
    // Игра Камень-Ножницы-Бумага
    public static void main(String[] args) throws InterruptedException {
        String rock = "✊";
        String scissors = "✌\uFE0F";
        String paper = "✋";
        Random random = new Random();

        // Ход первого игрока
        String firstPlayerName = "HEL";
        String firstPlayerShape = rock;
        int firstMagicNumber = random.nextInt(1, 100);
        if (firstMagicNumber > 66) {
            firstPlayerShape = paper;
        } else if (firstMagicNumber > 33) {
            firstPlayerShape = scissors;
        }

        System.out.println("Ход " + firstPlayerName + ": ");
        for (int i = 0; i < 5; i++) {
            System.out.print(rock + "\r");
            Thread.sleep(100);
            System.out.print(scissors + "\r");
            Thread.sleep(100);
            System.out.print(paper + "\r");
            Thread.sleep(100);
        }
        System.out.println(firstPlayerShape);

        // Ход второго игрока
        String secondPlayerName = "WALLE";
        String secondPlayerShape = rock;
        int secondMagicNumber = random.nextInt(1, 100);
        if (secondMagicNumber > 66) {
            secondPlayerShape = paper;
        } else if (secondMagicNumber > 33) {
            secondPlayerShape = scissors;
        }

        System.out.println("Ход " + secondPlayerName + ": ");
        for (int i = 0; i < 5; i++) {
            System.out.print(rock + "\r");
            Thread.sleep(100);
            System.out.print(scissors + "\r");
            Thread.sleep(100);
            System.out.print(paper + "\r");
            Thread.sleep(100);
        }
        System.out.println(secondPlayerShape);

        if (firstPlayerShape.equals(secondPlayerShape)) {
            System.out.println("Победила дружба!");
            return;
        }

        boolean isFirstPlayerWin = (firstPlayerShape.equals(rock) && secondPlayerShape.equals(scissors))
                || (firstPlayerShape.equals(scissors) && secondPlayerShape.equals(paper))
                || (firstPlayerShape.equals(paper) && secondPlayerShape.equals(rock));

        if (isFirstPlayerWin) {
            System.out.println("\nПобедил - " + firstPlayerName);
        } else {
            System.out.println("\nПобедил - " + secondPlayerName);
        }
    }
}