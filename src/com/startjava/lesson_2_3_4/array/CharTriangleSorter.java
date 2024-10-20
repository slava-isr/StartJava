package com.startjava.lesson_2_3_4.array;

public class CharTriangleSorter {

    public static void main(String[] args) {
        displayResult(sortCharacters('0', '9', true));
        displayResult(sortCharacters('/', '!', false));
        displayResult(sortCharacters('A', 'J', false));
    }

    private static char[] sortCharacters(char start, char end, boolean ascending) {
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

    private static void displayResult(char[] sortedCharacters) {
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
}