package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {

    private Console() {}

    public static void type(String text) throws InterruptedException {
        if (text == null || text.isBlank()) {
            System.out.printf("Ошибка: недопустимая строка (%s)%n%n", text == null ? text : "пусто");
            return;
        }
        for (char symbol : text.toCharArray()) {
            System.out.print(symbol);
            Thread.sleep(100);
        }
        System.out.println("\n");
    }

    public static void printTwoLinesInfo(float[] values, int thresholdValueIndex) {
        if (thresholdValueIndex < 0 || thresholdValueIndex >= values.length) return;
        System.out.println("Исходный массив:");
        System.out.print(twoLineArray(values));
        System.out.printf("Значение по индексу (%d): ", thresholdValueIndex);
        System.out.printf("%.3f%n%n", values[thresholdValueIndex]);
        System.out.printf("Обнуленных ячеек: %d%n", com.startjava.lesson_2_3_4.array.Arrays.resetCounter);
        System.out.println("Измененный массив:");
    }

    public static void printTwoLines(float[] overwrittenValues, int thresholdValueIndex) {
        int len = overwrittenValues.length;
        if (thresholdValueIndex < 0 || thresholdValueIndex >= len) {
            System.out.print("Ошибка: индекс должен быть в диапазоне [0, ");
            System.out.printf("%d] (%d)%n%n", len - 1, thresholdValueIndex);
            return;
        }
        System.out.println(twoLineArray(overwrittenValues));
    }

    public static void printMultiline(int[] values, int valuesPerLine) {
        int length = values.length;
        if (valuesPerLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)%n%n", valuesPerLine);
        } else if (length < 1) {
            System.out.printf("Ошибка: длина массива должна быть больше 0 (%d)%n%n", length);
        } else {
            for (int i = 0; i < length; i++) {
                System.out.printf("%4d", values[i]);
                if (((i + 1) % valuesPerLine == 0) || (i == length - 1)) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    public static void printFactorialsExpression(int[] values, long[] factorials) {
        if (factorials == null) return;
        for (int i = 0; i < factorials.length; i++) {
            long number = values[i];
            if (number < 0) {
                System.out.printf("Ошибка: факториал %d! не определен%n", number);
            } else {
                StringBuilder expression = new StringBuilder();
                expression.append(number).append("! = ");
                if (number < 2) {
                    expression.append("1");
                    System.out.println(expression);
                    continue;
                }
                for (int j = 1; j < number; j++) {
                    expression.append(j).append(" * ");
                }
                expression.append(number).append(" = ").append(factorials[i]);
                System.out.println(expression);
            }
        }
        System.out.println();
    }

    public static void printArrayInfo(int[] array) {
        System.out.printf("   До реверса: %s%n", Arrays.toString(array));
        System.out.print("После реверса: ");
    }

    public static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.printf("Ошибка: передан недопустимый массив (%s)%n%n", Arrays.toString(array));
        } else {
            System.out.printf("%s%n%n", Arrays.toString(array));
        }
    }

    public static void drawTriangle(char[] characters) {
        if (characters == null) return;
        StringBuilder triangle = new StringBuilder();
        int len = characters.length;
        for (int i = 0; i < len; i++) {
            triangle.append(" ".repeat(len - i - 1));
            triangle.append((characters[i] + "").repeat(2 * i + 1));
            triangle.append('\n');
        }
        System.out.println(triangle);
    }

    private static String twoLineArray(float[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("%.3f", array[i])).append("  ");
            if (i == 7) sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}