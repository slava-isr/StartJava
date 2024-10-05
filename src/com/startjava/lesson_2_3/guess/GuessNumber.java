package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumber {

    private final Player firstPlayer;
    private final Player secondPlayer;
    private final int rangeFrom;
    private final int rangeTo;
    private int guessNumber;

    public GuessNumber(Player firstPlayer, Player secondPlayer, int rangeFrom, int rangeTo) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public void start(Scanner sc) {
        generateGuessNumber();
        do {
            if (makeMove(firstPlayer, sc)) break;
        } while (!makeMove(secondPlayer, sc));
    }

    private void generateGuessNumber() {
        guessNumber = rangeFrom + (int) (Math.random() * (rangeTo - rangeFrom + 1));
        System.out.printf("Компьютер загадал число от %d до %d включительно!%n", rangeFrom, rangeTo);
    }

    private boolean makeMove(Player player, Scanner sc) {
        System.out.printf("Сейчас отвечает \"%s\": ", player.getName());
        inputNumber(player, sc);
        return isGuessed(player);
    }

    private void inputNumber(Player player, Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (number >= rangeFrom && number <= rangeTo) {
                    player.setNumber(number);
                    break;
                }
                System.out.printf("Ошибка! Введите число от %d до %d включительно: ", rangeFrom, rangeTo);
            } else {
                System.out.print("Ошибка! Поддерживаются только числа: ");
                sc.next();
            }
        }
    }

    private boolean isGuessed(Player player) {
        if (player.getNumber() == guessNumber) {
            System.out.println("Поздравляем! " + player.getName() + " победил!");
            return true;
        }
        System.out.print("Не угадал... введённое число ");
        if (player.getNumber() > guessNumber) {
            System.out.println("больше загаданного");
        } else {
            System.out.println("меньше загаданного");
        }
        return false;
    }
}