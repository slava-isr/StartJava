package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ReverseNumbers {

    public static void main(String[] args) {
        int[] numbers = new int[]{};
        int[] reversedNumbers = reverse(numbers);
        displayResult(numbers, reversedNumbers);
        numbers = null;
        reversedNumbers = reverse(numbers);
        displayResult(numbers, reversedNumbers);
        numbers = new int[]{6, 8, 9, 1};
        reversedNumbers = reverse(numbers);
        displayResult(numbers, reversedNumbers);
        numbers = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversedNumbers = reverse(numbers);
        displayResult(numbers, reversedNumbers);
    }

    private static int[] reverse(int[] numbers) {
        if (numbers == null || numbers.length == 0) return numbers;
        int len = numbers.length;
        int[] reversedNumbers = new int[len];
        for (int i = 0; i < len; i++) {
            reversedNumbers[len - 1 - i] = numbers[i];
        }
        return reversedNumbers;
    }

    private static void displayResult(int[] numbers, int[] reversedNumbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.printf("Ошибка: передан недопустимый массив (%s)%n%n", Arrays.toString(numbers));
        } else {
            System.out.printf("   До реверса: %s%n", Arrays.toString(numbers));
            System.out.printf("После реверса: %s%n%n", Arrays.toString(reversedNumbers));
        }
    }
}