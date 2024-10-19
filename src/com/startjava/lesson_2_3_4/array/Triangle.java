package com.startjava.lesson_2_3_4.array;

public class Triangle {

    public static void main(String[] args) {
        char start = '0';
        char end = '9';
        char[] sortedCharacters = sort(start, end, true);
        displayResult(start, end, sortedCharacters);
        start = '/';
        end = '!';
        sortedCharacters = sort(start, end, false);
        displayResult(start, end, sortedCharacters);
        start = 'A';
        end = 'J';
        sortedCharacters = sort(start, end, false);
        displayResult(start, end, sortedCharacters);
    }

    private static char[] sort(char start, char end, boolean ascending) {
        if (start > end) return null;
        char[] sortedCharacters = new char[end - start + 1];
        for (int i = 0; i < sortedCharacters.length; i++) {
            sortedCharacters[i] = (char) (ascending ? start + i : end - i);
        }
        return sortedCharacters;
    }

    private static void displayResult(char start, char end, char[] sortedCharacters) {
        StringBuilder sb = new StringBuilder();
        if (sortedCharacters == null) {
            sb.append("Ошибка: левая граница (").append((int) start).append(") ");
            sb.append("> правой (").append((int) end).append(")\n");
            return;
        }
        int len = sortedCharacters.length;
        for (int i = 0; i < len; i++) {
            sb.append(" ".repeat(len - i - 1));
            sb.append((sortedCharacters[i] + "").repeat(2 * i + 1));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}