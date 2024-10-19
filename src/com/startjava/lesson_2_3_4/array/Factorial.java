package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Factorial {

    public static void main(String[] args) {
        long[] sourceNumbers = new long[]{};
        displayResult(sourceNumbers, calculate(sourceNumbers));
        sourceNumbers = null;
        displayResult(sourceNumbers, calculate(sourceNumbers));
        sourceNumbers = new long[]{8, 0, 9};
        displayResult(sourceNumbers, calculate(sourceNumbers));
        sourceNumbers = new long[]{-3, 1, 7, 13};
        displayResult(sourceNumbers, calculate(sourceNumbers));
        sourceNumbers = new long[]{-22, -0};
        displayResult(sourceNumbers, calculate(sourceNumbers));
    }

    private static long[] calculate(long... sourceNumbers) {
        if (sourceNumbers == null || sourceNumbers.length == 0) return sourceNumbers;
        int len = sourceNumbers.length;
        long[] factorials = new long[len];
        for (int i = 0; i < len; i++) {
            long factorial = 1;
            for (int j = 2; j <= sourceNumbers[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    public static void displayResult(long[] sourceNumbers, long[] factorials) {
        if (sourceNumbers == null || sourceNumbers.length == 0) {
            System.out.printf("Ошибка: передан недопустимый массив (%s)%n%n", Arrays.toString(sourceNumbers));
            return;
        }
        for (int i = 0; i < factorials.length; i++) {
            if (sourceNumbers[i] < 0) {
                System.out.printf("Ошибка: факториал %d! не определен%n", sourceNumbers[i]);
            } else {
                System.out.println(createExpression(sourceNumbers[i], factorials[i]));
            }
        }
        System.out.println();
    }

    private static String createExpression(long number, long factorial) {
        StringBuilder sb = new StringBuilder();
        sb.append(number).append("! = ");
        if (number < 2) {
            return sb.append("1").toString();
        }
        for (int j = 1; j < number; j++) {
            sb.append(j).append(" * ");
        }
        sb.append(number).append(" = ").append(factorial);
        return sb.toString();
    }
}