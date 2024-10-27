package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    public static int resetCounter;

    public static char[] sortCharacters(char start, char end, boolean ascending) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", (int) start, (int) end);
            return null;
        }
        char[] sortedCharacters = new char[end - start + 1];
        for (int i = 0; i < sortedCharacters.length; i++) {
            sortedCharacters[i] = ascending ? start++ : end--;
        }
        return sortedCharacters;
    }

    public static int[] reverse(int[] sourceValues) {
        if (sourceValues == null || sourceValues.length == 0) return sourceValues;
        int len = sourceValues.length;
        int[] reversedValues = new int[len];
        for (int i = 0; i < len; i++) {
            reversedValues[len - 1 - i] = sourceValues[i];
        }
        return reversedValues;
    }

    public static float[] resetValues(float[] sourceValues, int thresholdValueIndex) {
        int len = sourceValues.length;
        if (thresholdValueIndex < 0 || thresholdValueIndex >= len) return new float[15];
        float[] overwrittenValues = new float[len];
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

    public static int[] createUniqueValues(int start, int end) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return new int[0];
        }
        int len = (int) (Math.abs(end - start) * 0.75);
        int[] uniqueValues = new int[len];
        int i = 0;
        while (i < len) {
            boolean isUniqueValue = true;
            int uniqueValue = new Random().nextInt(end - start + 1) + start;
            for (int j = 0; j < i; j++) {
                if (uniqueValue == uniqueValues[i]) {
                    isUniqueValue = false;
                    break;
                }
            }
            if (isUniqueValue) uniqueValues[i++] = uniqueValue;
        }
        java.util.Arrays.sort(uniqueValues);
        return uniqueValues;
    }

    public static float[] createRandomValues(int length) {
        float[] values = new float[length];
        for (int i = 0; i < values.length; i++) {
            values[i] = (float) Math.random();
        }
        return values;
    }

    public static String upperCaseRange(String text) {
        if (text == null || text.isBlank()) return text;
        String[] words = text.split(" ");
        String minWord = words[0];
        String maxWord = words[0];
        int minWordIndex = 0;
        int maxWordIndex = 0;
        for (int i = 1; i < words.length; i++) {
            String word = words[i].replaceAll("\\p{P}", "");
            if (word.length() < minWord.length() && !word.isBlank()) {
                minWord = word;
                minWordIndex = i;
            }
            if (word.length() > maxWord.length()) {
                maxWord = word;
                maxWordIndex = i;
            }
        }
        if (minWordIndex > maxWordIndex) {
            minWordIndex ^= maxWordIndex;
            maxWordIndex ^= minWordIndex;
            minWordIndex ^= maxWordIndex;
        }
        for (int i = minWordIndex; i <= maxWordIndex; i++) {
            words[i] = words[i].toUpperCase();
        }
        return String.join(" ", words);
    }

    public static long[] factorials(int... sourceValues) {
        if (sourceValues == null || sourceValues.length == 0) {
            System.out.printf("Ошибка: передан недопустимый массив (%s)%n%n", java.util.Arrays.toString(sourceValues));
            return null;
        }
        int len = sourceValues.length;
        long[] factorials = new long[len];
        for (int i = 0; i < len; i++) {
            long factorial = 1;
            for (int j = 2; j <= sourceValues[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }
}