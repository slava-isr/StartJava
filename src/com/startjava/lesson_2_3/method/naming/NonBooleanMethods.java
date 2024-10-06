package com.startjava.lesson_2_3.method.naming;

public class NonBooleanMethods {

    public void findLongestWord() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> найти самое длинное слово в предложении из книги по Java");
    }

    public void selectMenuItem() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> выбрать пункт меню в текстовом редакторе на macOS");
    }

    public void calculateAvgGrade() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> вычислить среднее значение оценок в школе №1234");
    }

    public void countUniqueWords() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> подсчитать количество уникальных слов в \"Война и Мир\"");
    }

    public void showErrorMessage() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> вывести сообщение об ошибке");
    }

    public void synchronizeData() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> синхронизировать данные с облачным хранилищем");
    }

    public void recoverData() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> восстановить данные из резервной копии от 11.03.2024");
    }

    public void pauseDownload() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> приостановить загрузку mp3-файла группы \"Ария\"");
    }

    public void resetSettings() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> сбросить настройки до заводских для пылесоса Mi");
    }

    public void writeToFile() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> записать содержимое в файл по указанному пути на флешку");
    }

    public void convertTempCelsiusToFahrenheit() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> преобразовать температуру из Цельсия в Фаренгейт");
    }

    public void enterMathExpression() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> ввести математическое выражение с тремя аргументами");
    }

    public void revealWinner() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> выявить победителя среди гонщиков игры \"Need For Speed\"");
    }

    public void findBookByAuthor() {
        System.out.println(CurrentMethodNameUtil.getName() +
                "() -> найти книгу по имени писателя");
    }
}