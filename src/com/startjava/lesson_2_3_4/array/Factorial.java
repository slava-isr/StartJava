package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Factorial {

    public static void main(String[] args) {
        long[] factorials = toCalculate(new long[]{});
        displayResult(factorials, new long[]{});
        factorials = toCalculate(null);
        displayResult(factorials, null);
        factorials = toCalculate(8, 0, 9);
        displayResult(factorials, 8, 0, 9);
        factorials = toCalculate(-3, 1, 7, 13);
        displayResult(factorials, -3, 1, 7, 13);
        factorials = toCalculate(-22, -0);
        displayResult(factorials, -22, -0);
    }

    private static long[] toCalculate(long... numbers) {
        if (numbers == null || numbers.length == 0) return numbers;
        int len = numbers.length;
        long[] factorials = Arrays.copyOf(numbers, len);
        for (int i = 0; i < len; i++) {
            if (numbers[i] == 0 || numbers[i] == 1) {
                factorials[i] = 1;
            } else {
                long factorial = 1;
                for (int j = 2; j <= numbers[i]; j++) {
                    factorial *= j;
                }
                factorials[i] = factorial;
            }
        }
        return factorials;
    }

    public static void displayResult(long[] factorials, long... sourceNumbers) {
        if (sourceNumbers == null || sourceNumbers.length == 0) {
            System.out.printf("Ошибка: передан недопустимый массив (%s)%n%n", Arrays.toString(sourceNumbers));
        } else {
            for (int i = 0; i < factorials.length; i++) {
                if (sourceNumbers[i] < 0) System.out.printf("Ошибка: факториал %d! не определен%n", sourceNumbers[i]);
                else System.out.println(createMultiplicationLine(sourceNumbers[i], factorials[i]));
            }
            System.out.println();
        }
    }

    private static String createMultiplicationLine(long number, long factorial) {
        String line = number + "! = ";
        if (number < 2) return line + "1";
        for (int j = 1; j < number; j++) {
            line += j + " * ";
        }
        line += number + " = " + factorial;
        return line;
    }
}