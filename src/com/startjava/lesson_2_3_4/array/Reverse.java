package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        Result result = reverse(new int[]{});
        System.out.println(result);
        result = reverse(null);
        System.out.println(result);
        result = reverse(new int[]{6, 8, 9, 1});
        System.out.println(result);
        result = reverse(new int[]{13, 8, 5, 3, 2, 1, 1});
        System.out.print(result);
    }

    private static Result reverse(int[] numbers) {
        if (numbers == null || numbers.length == 0) return new Result(numbers, null);
        int len = numbers.length;
        int[] reversedNumbers = new int[len];
        for (int i = 0; i < len; i++) {
            reversedNumbers[len - 1 - i] = numbers[i];
        }
        return new Result(numbers, reversedNumbers);
    }

    private record Result(int[] numbers, int[] reversedNumbers) {

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (reversedNumbers == null) {
                sb.append("Ошибка: передан недопустимый массив (").append(Arrays.toString(numbers)).append(")\n");
            } else {
                sb.append("   До реверса: ").append(Arrays.toString(numbers)).append("\n");
                sb.append("После реверса: ").append(Arrays.toString(reversedNumbers)).append("\n");
            }
            return sb.toString();
        }
    }
}