package com.startjava.lesson_2_3.method.naming;

public class BooleanMethods {

    public boolean isAppEnd() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> программа завершается? ");
        return true;
    }

    public boolean isFileDeleted() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> файл удален? ");
        return true;
    }

    public boolean haveUniqueDigit() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> есть уникальная цифра? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> это буква? ");
        return true;
    }

    public boolean haveEqualDigits() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> есть равные цифры? ");
        return true;
    }

    public boolean haveAttempts() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> есть попытки? ");
        return true;
    }

    public boolean isEmptyLine() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> строка пустая? ");
        return true;
    }

    public boolean isEvenNumber() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> это четное число? ");
        return true;
    }

    public boolean isPathValid() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> путь действителен? ");
        return true;
    }

    public boolean isFileExist() {
        System.out.print(CurrentMethodNameUtil.getName() + "() -> существует ли файл? ");
        return true;
    }
}