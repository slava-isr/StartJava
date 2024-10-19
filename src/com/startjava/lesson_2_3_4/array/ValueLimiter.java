package com.startjava.lesson_2_3_4.array;

import java.text.DecimalFormat;

public class ValueLimiter {
    private static int resetCounter;

    public static void main(String[] args) {
        int[] thresholdValueIndexes = {-1, 15, 0, 14};
        for (int index : thresholdValueIndexes) {
            float[] sourceValues = new float[15];
            for (int i = 0; i < sourceValues.length; i++) sourceValues[i] = (float) Math.random();
            displayResult(sourceValues, resetValues(index, sourceValues), index);
        }
    }

    private static float[] resetValues(int thresholdValueIndex, float[] sourceValues) {
        int len = sourceValues.length;
        if (thresholdValueIndex < 0 || thresholdValueIndex >= len) return null;
        float[] overwrittenValues = new float[len];
        resetCounter = 0;
        float thresholdValue = sourceValues[thresholdValueIndex];
        for (int i = 0; i < len; i++) {
            if (sourceValues[i] > thresholdValue) {
                overwrittenValues[i] = 0;
                resetCounter++;
            } else {
                overwrittenValues[i] = sourceValues[i];
            }
        }
        return overwrittenValues;
    }

    private static void displayResult(float[] sourceValues, float[] overwrittenValues, int thresholdValueIndex) {
        int len = sourceValues.length;
        if (thresholdValueIndex < 0 || thresholdValueIndex >= len) {
            System.out.print("Ошибка: индекс должен быть в диапазоне [0, ");
            System.out.printf("%d] (%d)%n%n", len - 1, thresholdValueIndex);
            return;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println("Исходный массив:");
        System.out.println(valuesToString(sourceValues, df));
        System.out.printf("Значение по индексу (%d): ", thresholdValueIndex);
        System.out.printf("%s%n%n", df.format(sourceValues[thresholdValueIndex]));
        System.out.println("Измененный массив:");
        System.out.println(valuesToString(overwrittenValues, df));
        System.out.printf("Количество обнуленных ячеек: %d%n%n", resetCounter);
    }

    private static String valuesToString(float[] values, DecimalFormat df) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(df.format(values[i])).append("  ");
            if (i == 7) sb.append("\n");
        }
        return sb.toString();
    }
}