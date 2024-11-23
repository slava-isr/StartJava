package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final int[] numbers = new int[GuessNumber.MAX_ATTEMPTS];
    private final String name;
    private int numbersCount = 0;
    private int winCount = 0;

    public Player(String name) {
        this.name = name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbersCount);
    }

    public String getName() {
        return name;
    }

    public int getWinCount() {
        return winCount;
    }

    public boolean addNumber(int number, int rangeFrom, int rangeTo) {
        if (Arrays.stream(getNumbers()).anyMatch(n -> n == number)) {
            System.out.printf("Число %d уже использовалось.%n%nПопробуйте еще раз: ", number);
            return false;
        }
        if (number < rangeFrom || number > rangeTo) {
            System.out.printf("Число должно входить в отрезок [%d, %d].%n%nПопробуйте еще раз: ",
                    rangeFrom, rangeTo);
            return false;
        }
        numbers[numbersCount++] = number;
        return true;
    }

    public void increaseWinCount() {
        winCount++;
    }

    public void clearNumbers() {
        Arrays.fill(numbers, 0, numbersCount, 0);
        numbersCount = 0;
    }
}