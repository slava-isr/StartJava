package com.startjava.lesson_2_3_4.array;

public class Triangle {

    public static void main(String[] args) {
        char start = '0';
        char end = '9';
        displayResult(sortCharacters(start, end, true), start, end);
        start = '/';
        end = '!';
        displayResult(sortCharacters(start, end, false), start, end);
        start = 'A';
        end = 'J';
        displayResult(sortCharacters(start, end, false), start, end);
    }

    private static char[] sortCharacters(char start, char end, boolean ascending) {
        if (start > end) return null;
        char[] sortedCharacters = new char[end - start + 1];
        for (int i = 0; i < sortedCharacters.length; i++) {
            sortedCharacters[i] = (char) (ascending ? start + i : end - i);
        }
        return sortedCharacters;
    }

    private static void displayResult(char[] sortedCharacters, char start, char end) {
        if (sortedCharacters == null) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", (int) start, (int) end);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int len = sortedCharacters.length;
        for (int i = 0; i < len; i++) {
            sb.append(" ".repeat(len - i - 1));
            sb.append((sortedCharacters[i] + "").repeat(2 * i + 1));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}