package com.startjava.lesson_2_3_4.array;

public class Typewriter {

    public static void main(String[] args) throws InterruptedException {
        String jamesQuote = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        String robertsQuote = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        displayText(capitalize(jamesQuote));
        displayText(capitalize(robertsQuote));
        displayText(capitalize(null));
        displayText(capitalize(""));
    }

    private static void displayText(String text) throws InterruptedException {
        if (text == null || text.isBlank()) {
            System.out.println("Ошибка: передана недопустимая строка\n");
            return;
        }
        for (char symbol : text.toCharArray()) {
            System.out.print(symbol);
            Thread.sleep(100);
        }
        System.out.println("\n");
    }

    private static String capitalize(String text) {
        if (text == null || text.isBlank()) return text;
        String[] words = text.split(" ");
        String minWord = words[0];
        String maxWord = words[0];
        int minWordIndex = 0;
        int maxWordIndex = 0;
        for (int i = 1; i < words.length; i++) {
            String word = words[i].replaceAll("\\p{P}", "");
            int wordLength = word.length();
            if (wordLength < minWord.length() && !word.isBlank()) {
                minWord = word;
                minWordIndex = i;
            }
            if (wordLength > maxWord.length()) {
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
}