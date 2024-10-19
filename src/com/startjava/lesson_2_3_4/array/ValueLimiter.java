package com.startjava.lesson_2_3_4.array;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ValueLimiter {
    private static final int ARRAY_SIZE = 15;
    private static int resetCounter = 0;

    public static void main(String[] args) {
        int[] thresholdValueIndexes = {-1, 15, 0, 14};
        for (int index : thresholdValueIndexes) {
            displayResult(index, resetValues(index));
        }
    }

    private static double[][] resetValues(int thresholdValueIndex) {
        if (thresholdValueIndex < 0 || thresholdValueIndex >= ARRAY_SIZE) return null;
        double[] sourceValues = new double[ARRAY_SIZE];
        Arrays.setAll(sourceValues, value -> Math.random());
        double[] overwrittenValues = new double[ARRAY_SIZE];
        resetCounter = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (Double.compare(sourceValues[i], sourceValues[thresholdValueIndex]) > 0) {
                overwrittenValues[i] = 0;
                resetCounter++;
            } else {
                overwrittenValues[i] = sourceValues[i];
            }
        }
        return new double[][]{sourceValues, overwrittenValues};
    }

    private static void displayResult(int thresholdValueIndex, double[][] results) {
        if (thresholdValueIndex < 0 || thresholdValueIndex >= ARRAY_SIZE) {
            System.out.print("Ошибка: индекс должен быть в диапазоне [0, ");
            System.out.printf("%d] (%d)%n%n", ARRAY_SIZE - 1, thresholdValueIndex);
            return;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        double[] sourceValues = results[0];
        System.out.println("Исходный массив:");
        System.out.println(valuesToString(Arrays.copyOfRange(sourceValues, 0, 8), df));
        System.out.println(valuesToString(Arrays.copyOfRange(sourceValues, 8, ARRAY_SIZE), df));
        System.out.printf("Значение по индексу (%d): ", thresholdValueIndex);
        System.out.printf("%s%n%n", df.format(sourceValues[thresholdValueIndex]));
        double[] overwrittenValues = results[1];
        System.out.println("Измененный массив:");
        System.out.println(valuesToString(Arrays.copyOfRange(overwrittenValues, 0, 8), df));
        System.out.println(valuesToString(Arrays.copyOfRange(overwrittenValues, 8, ARRAY_SIZE), df));
        System.out.printf("Количество обнуленных ячеек: %d%n%n", resetCounter);
    }

    private static String valuesToString(double[] values, DecimalFormat df) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < values.length; i++) {
            sb.append(df.format(values[i]));
            if (i < values.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}