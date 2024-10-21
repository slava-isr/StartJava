package com.startjava.lesson_2_3_4.array;

public class Typewriter {

    public static void main(String[] args) throws InterruptedException {
        String jamesQuote = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        String robertsQuote = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        type(jamesQuote);
        type(robertsQuote);
        type(null);
        type("");
    }

    private static void type(String text) throws InterruptedException {
        if (text == null || text.isBlank()) {
            System.out.printf("Ошибка: недопустимая строка (%s)%n%n", text == null ? text : "пусто");
            return;
        }
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
        displayText(String.join(" ", words));
    }

    private static void displayText(String text) throws InterruptedException {
        for (char symbol : text.toCharArray()) {
            System.out.print(symbol);
            Thread.sleep(100);
        }
        System.out.println("\n");
    }
}