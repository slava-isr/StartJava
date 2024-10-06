package com.startjava.lesson_2_3.method.naming;

public class MethodNamesThemeTest {

    public static void main(String[] args) {
        System.out.println("1. Hе boolean-методы");
        executeNonBooleanMethods(new NonBooleanMethods());

        System.out.println("\n2. boolean-методы (должны возвращать true или false)");
        executeBooleanMethods(new BooleanMethods());
    }

    private static void executeNonBooleanMethods(NonBooleanMethods nbm) {
        nbm.findLongestWord();
        nbm.selectMenuItem();
        nbm.calculateAvgRatings();
        nbm.countUniqueWords();
        nbm.showErrorMessage();
        nbm.synchronizeData();
        nbm.recoverData();
        nbm.pauseDownload();
        nbm.resetSettings();
        nbm.writeToFile();
        nbm.convertTemperature();
        nbm.enterExpression();
        nbm.getWinner();
        nbm.findBook();
    }

    private static void executeBooleanMethods(BooleanMethods bm) {
        System.out.println(bm.isAppEnd());
        System.out.println(bm.isFileDeleted());
        System.out.println(bm.haveUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.haveEqualDigits());
        System.out.println(bm.haveAttempts());
        System.out.println(bm.isEmptyLine());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isPathValid());
        System.out.println(bm.isFileExist());
    }
}