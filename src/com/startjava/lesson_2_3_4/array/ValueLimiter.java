package com.startjava.lesson_2_3_4.array;

public class ValueLimiter {
    private static int resetCounter;

    public static void main(String[] args) {
        int[] thresholdValueIndexes = {-1, 15, 0, 14};
        for (int index : thresholdValueIndexes) {
            float[] sourceValues = createValues(15);
            displayResult(sourceValues, resetValues(sourceValues, index), index);
        }
    }

    private static float[] createValues(int length) {
        float[] values = new float[length];
        for (int i = 0; i < values.length; i++) {
            values[i] = (float) Math.random();
        }
        return values;
    }

    private static float[] resetValues(float[] sourceValues, int thresholdValueIndex) {
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
        System.out.println("Исходный массив:");
        System.out.println(arrayToString(sourceValues));
        System.out.printf("Значение по индексу (%d): ", thresholdValueIndex);
        System.out.printf("%.3f%n%n", sourceValues[thresholdValueIndex]);
        System.out.println("Измененный массив:");
        System.out.println(arrayToString(overwrittenValues));
        System.out.printf("Количество обнуленных ячеек: %d%n%n", resetCounter);
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