package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {

    public static void displayText(String text) throws InterruptedException {
        for (char symbol : text.toCharArray()) {
            System.out.print(symbol);
            Thread.sleep(100);
        }
        System.out.println("\n");
    }

    public static void displayResult(char[] sortedCharacters) {
        if (sortedCharacters == null) return;
        StringBuilder triangle = new StringBuilder();
        int len = sortedCharacters.length;
        for (int i = 0; i < len; i++) {
            triangle.append(" ".repeat(len - i - 1));
            triangle.append((sortedCharacters[i] + "").repeat(2 * i + 1));
            triangle.append('\n');
        }
        System.out.println(triangle);
    }

    public static void displayResult(int[] uniqueNumbers, int numbersPerLine) {
        int length = uniqueNumbers.length;
        if (numbersPerLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)%n%n", numbersPerLine);
        } else if (length < 1) {
            System.out.printf("Ошибка: длина массива должна быть больше 0 (%d)%n%n", length);
        } else {
            for (int i = 0; i < length; i++) {
                System.out.printf("%4d", uniqueNumbers[i]);
                if (((i + 1) % numbersPerLine == 0) || (i == length - 1)) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    public static void displayResult(int[] sourceNumbers, int[] reversedNumbers) {
        if (sourceNumbers == null || sourceNumbers.length == 0) {
            System.out.printf("Ошибка: передан недопустимый массив (%s)%n%n", java.util.Arrays.toString(sourceNumbers));
        } else {
            System.out.printf("   До реверса: %s%n", java.util.Arrays.toString(sourceNumbers));
            System.out.printf("После реверса: %s%n%n", Arrays.toString(reversedNumbers));
        }
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

    public static void displayResult(float[] sourceValues, float[] overwrittenValues, int thresholdValueIndex) {
        int len = sourceValues.length;
        if (thresholdValueIndex < 0 || thresholdValueIndex >= len) {
            System.out.print("Ошибка: индекс должен быть в диапазоне [0, ");
            System.out.printf("%d] (%d)%n%n", len - 1, thresholdValueIndex);
            return;
        }
        System.out.println("Исходный массив:");
        System.out.println(arrayToString(sourceValues));
        System.out.printf("Значение по индексу (%d): ", thresholdValueIndex);
        System.out.printf("%.3f%n%n", sourceValues[thresholdValueIndex]);
        System.out.println("Измененный массив:");
        System.out.println(arrayToString(overwrittenValues));
        System.out.printf("Количество обнуленных ячеек: %d%n%n", com.startjava.lesson_2_3_4.array.Arrays.resetCounter);
    }

    private static String createExpression(long number, long factorial) {
        StringBuilder sb = new StringBuilder();
        sb.append(number).append("! = ");
        if (number < 2) {
            sb.append("1");
            return sb.toString();
        }
        for (int j = 1; j < number; j++) {
            sb.append(j).append(" * ");
        }
        sb.append(number).append(" = ").append(factorial);
        return sb.toString();
    }

    private static String arrayToString(float[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("%.3f", array[i])).append("  ");
            if (i == 7) sb.append("\n");
        }
        return sb.toString();
    }
}