package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static boolean isCalculated = false;
    private static boolean isCorrectUserAnswer = true;

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\".");
        System.out.println("Будьте внимательны - программа работает только с целыми числами.");
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        do {
            if (!isCalculated) {
                System.out.print("\nВведите выражение из трех аргументов, например, 2 ^ 10: ");
                String expression = sc.nextLine().trim().replaceAll("\\s+", " ");
                printFormattedResult(expression, calculator.calculate(expression));
            }
        } while (isContinueCalculate(sc));
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static void printFormattedResult(String expression, double result) {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            System.out.println("\nУпс! Получено недопустимое значение. Проверьте выражение и попробуйте снова.");
        } else {
            DecimalFormat df = new DecimalFormat("#.####");
            System.out.printf("%n%s = %s%n", expression, df.format(result));
        }
        isCalculated = true;
    }

    private static boolean isContinueCalculate(Scanner sc) {
        System.out.printf("%n%s [yes / no]: ",
                isCorrectUserAnswer ? "Хотите продолжить вычисления?" : "Введите корректный ответ");
        String userAnswer = sc.nextLine().trim().toLowerCase();
        if ("no".equals(userAnswer)) return false;
        if ("yes".equals(userAnswer)) {
            isCalculated = false;
            isCorrectUserAnswer = true;
            return true;
        }
        isCorrectUserAnswer = false;
        return true;
    }
}