package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ReverseNumbers {

    public static void main(String[] args) {
        int[] sourceNumbers = new int[]{};
        int[] reversedNumbers = reverse(sourceNumbers);
        displayResult(sourceNumbers, reversedNumbers);
        sourceNumbers = null;
        reversedNumbers = reverse(sourceNumbers);
        displayResult(sourceNumbers, reversedNumbers);
        sourceNumbers = new int[]{6, 8, 9, 1};
        reversedNumbers = reverse(sourceNumbers);
        displayResult(sourceNumbers, reversedNumbers);
        sourceNumbers = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversedNumbers = reverse(sourceNumbers);
        displayResult(sourceNumbers, reversedNumbers);
    }

    private static int[] reverse(int[] sourceNumbers) {
        if (sourceNumbers == null || sourceNumbers.length == 0) return sourceNumbers;
        int len = sourceNumbers.length;
        int[] reversedNumbers = new int[len];
        for (int i = 0; i < len; i++) {
            reversedNumbers[len - 1 - i] = sourceNumbers[i];
        }
        return reversedNumbers;
    }

    private static void displayResult(int[] sourceNumbers, int[] reversedNumbers) {
        if (sourceNumbers == null || sourceNumbers.length == 0) {
            System.out.printf("Ошибка: передан недопустимый массив (%s)%n%n", Arrays.toString(sourceNumbers));
        } else {
            System.out.printf("   До реверса: %s%n", Arrays.toString(sourceNumbers));
            System.out.printf("После реверса: %s%n%n", Arrays.toString(reversedNumbers));
        }
    }
}