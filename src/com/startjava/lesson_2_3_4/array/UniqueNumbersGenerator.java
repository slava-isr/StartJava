package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersGenerator {

    public static void main(String[] args) {
        displayResult(createNumbers(-10, 20), 23);
        displayResult(createNumbers(-30, 10), 10);
        displayResult(createNumbers(-34, -34), 0);
        displayResult(createNumbers(-1, 2), -3);
        displayResult(createNumbers(5, -8), 2);
    }

    private static int[] createNumbers(int start, int end) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return new int[0];
        }
        int length = (int) (Math.abs(end - start) * 0.75);
        int[] uniqueNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            uniqueNumbers[i] = new Random().nextInt(end - start + 1) + start;
        }
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    public static void displayResult(int[] uniqueNumbers, int numbersPerLine) {
        int length = uniqueNumbers.length;
        if (numbersPerLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)%n%n", numbersPerLine);
        } else if (length < 1) {
            System.out.printf("Ошибка: длина массива должна быть больше 0 (%d)%n%n", length);
        } else {
            for (int i = 0; i < length; i++) {
                System.out.printf("%-4d", uniqueNumbers[i]);
                if (((i + 1) % numbersPerLine == 0) || (i == length - 1)) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}