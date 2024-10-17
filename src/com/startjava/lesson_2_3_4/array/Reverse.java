package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        int[] numbers = new int[]{};
        int[] reversedNumbers = reverse(numbers);
        System.out.println(resultToString(numbers, reversedNumbers));

        numbers = null;
        reversedNumbers = reverse(numbers);
        System.out.println(resultToString(numbers, reversedNumbers));

        numbers = new int[]{6, 8, 9, 1};
        reversedNumbers = reverse(numbers);
        System.out.println(resultToString(numbers, reversedNumbers));

        numbers = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversedNumbers = reverse(numbers);
        System.out.print(resultToString(numbers, reversedNumbers));
    }

    private static int[] reverse(int[] numbers) {
        if (numbers == null || numbers.length == 0) return numbers;
        int length = numbers.length;
        int[] reversedNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            reversedNumbers[length - 1 - i] = numbers[i];
        }
        return reversedNumbers;
    }

    private static String resultToString(int[] numbers, int[] reversedNumbers) {
        StringBuilder result = new StringBuilder();
        if (numbers == null || numbers.length == 0) {
            result.append("Ошибка: передан недопустимый массив").append("\n");
        } else {
            result.append("   До реверса: ").append(Arrays.toString(numbers)).append("\n");
            result.append("После реверса: ").append(Arrays.toString(reversedNumbers)).append("\n");
        }
        return result.toString();
    }
}