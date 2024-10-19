package com.startjava.lesson_2_3_4.array;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ValueLimiter {
    private static int resetCounter = 0;

    public static void main(String[] args) {
        int[] thresholdValueIndexes = {-1, 15, 0, 14};
        for (int index : thresholdValueIndexes) {
            double[] sourceValues = new double[15];
            Arrays.setAll(sourceValues, value -> Math.random());
            displayResult(index, sourceValues, resetValues(index, sourceValues));
        }
    }

    private static double[] resetValues(int thresholdValueIndex, double[] sourceValues) {
        int len = sourceValues.length;
        if (thresholdValueIndex < 0 || thresholdValueIndex >= len) return null;
        double[] overwrittenValues = new double[len];
        resetCounter = 0;
        for (int i = 0; i < len; i++) {
            if (Double.compare(sourceValues[i], sourceValues[thresholdValueIndex]) > 0) {
                overwrittenValues[i] = 0;
                resetCounter++;
            } else {
                overwrittenValues[i] = sourceValues[i];
            }
        }
        return overwrittenValues;
    }

    private static void displayResult(int thresholdValueIndex, double[] sourceValues, double[] overwrittenValues) {
        int len = sourceValues.length;
        if (thresholdValueIndex < 0 || thresholdValueIndex >= len) {
            System.out.print("Ошибка: индекс должен быть в диапазоне [0, ");
            System.out.printf("%d] (%d)%n%n", len - 1, thresholdValueIndex);
            return;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println("Исходный массив:");
        System.out.println(valuesToString(Arrays.copyOfRange(sourceValues, 0, 8), df));
        System.out.println(valuesToString(Arrays.copyOfRange(sourceValues, 8, len), df));
        System.out.printf("Значение по индексу (%d): ", thresholdValueIndex);
        System.out.printf("%s%n%n", df.format(sourceValues[thresholdValueIndex]));
        System.out.println("Измененный массив:");
        System.out.println(valuesToString(Arrays.copyOfRange(overwrittenValues, 0, 8), df));
        System.out.println(valuesToString(Arrays.copyOfRange(overwrittenValues, 8, len), df));
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