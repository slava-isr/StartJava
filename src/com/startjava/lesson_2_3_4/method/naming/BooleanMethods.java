package com.startjava.lesson_2_3_4.method.naming;

public class BooleanMethods {

    public boolean isAppEnd() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean isFileDeleted() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> удалился ли файл на жестком диске или флешке? ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return true;
    }

    public boolean hasAttempts() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isEmptyLine() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return true;
    }

    public boolean isEvenNumber() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public boolean isValidPath() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return true;
    }

    public boolean isFileExist() {
        System.out.print(CurrentMethodNameUtil.getName() +
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}