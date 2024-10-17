package com.startjava.lesson_2_3_4.array;

public class ReverseArray {

    public static void main(String[] args) {
        displayReversedArray(new int[]{});
        System.out.println();
        displayReversedArray(null);
        System.out.println();
        displayReversedArray(new int[]{6, 8, 9, 1});
        System.out.println();
        displayReversedArray(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void displayReversedArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Ошибка: передан недопустимый массив");
            return;
        }
        int[] result = reverse(numbers);
        System.out.println("   До реверса: " + toString(numbers));
        System.out.println("После реверса: " + toString(result));
    }

    private static int[] reverse(int[] numbers) {
        int arrayLength = numbers.length;
        int[] reversedNumbers = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            reversedNumbers[arrayLength - 1 - i] = numbers[i];
        }
        return reversedNumbers;
    }

    private static String toString(int[] array) {
        int iMax = array.length - 1;
        if (iMax == -1) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; ; i++) {
            sb.append(array[i]);
            if (i == iMax) return sb.append("]").toString();
            sb.append(", ");
        }
    }
}