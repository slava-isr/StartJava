package com.startjava.lesson_2_3_4.array;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ValueLimiter {
    private static final int ARRAY_SIZE = 15;

    public static void main(String[] args) {
        int thresholdValueIndex = -1;
        double[][] results = resetValues(-1);
        displayResult(thresholdValueIndex, results);
        thresholdValueIndex = 15;
        results = resetValues(thresholdValueIndex);
        displayResult(thresholdValueIndex, results);
        thresholdValueIndex = 0;
        results = resetValues(thresholdValueIndex);
        displayResult(thresholdValueIndex, results);
        thresholdValueIndex = 14;
        results = resetValues(thresholdValueIndex);
        displayResult(thresholdValueIndex, results);
    }

    private static double[][] resetValues(int thresholdValueIndex) {
        if (thresholdValueIndex < 0 || thresholdValueIndex >= ARRAY_SIZE) return null;
        double[] sourceValues = new double[ARRAY_SIZE];
        Arrays.setAll(sourceValues, value -> Math.random());
        double[] overwrittenValues = new double[ARRAY_SIZE];
        int resetCounter = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (Double.compare(sourceValues[i], sourceValues[thresholdValueIndex]) > 0) {
                overwrittenValues[i] = 0;
                resetCounter++;
            } else {
                overwrittenValues[i] = sourceValues[i];
            }
        }
        return new double[][]{sourceValues, overwrittenValues, {resetCounter}};
    }

    private static void displayResult(int thresholdValueIndex, double[][] results) {
        if (thresholdValueIndex < 0 || thresholdValueIndex >= ARRAY_SIZE) {
            System.out.print("Ошибка: индекс должен быть в диапазоне [0, ");
            System.out.printf("%d] (%d)%n", ARRAY_SIZE - 1, thresholdValueIndex);
        } else {
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
            int resetCounter = (int) results[2][0];
            System.out.printf("Количество обнуленных ячеек: %d%n", resetCounter);
        }
        System.out.println();
    }

    private static String valuesToString(double[] values, DecimalFormat df) {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < values.length; i++) {
            str.append(df.format(values[i]));
            if (i < values.length - 1) str.append(", ");
        }
        str.append("]");
        return str.toString();
    }
}