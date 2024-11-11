package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\".");
        System.out.println("Будьте внимательны - программа работает только с целыми числами.");
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        do {
            do {
                System.out.print("\nВведите математическое выражение: ");
            } while (!calculator.isExpressionValid(sc.nextLine()));
            printFormattedResult(calculator.getExpression(), calculator.calculate());
        } while (promptToContinue("\nХотите продолжить вычисления? [yes/no]: ", sc));
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static void printFormattedResult(String expression, double result) {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            System.out.println("\nУпс! Получено недопустимое значение. Проверьте выражение и попробуйте снова.");
            return;
        }
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.printf("%n%s = %s%n", expression, df.format(result));
    }

    private static boolean promptToContinue(String message, Scanner sc) {
        System.out.print(message);
        String playerAnswer = sc.nextLine().trim().toLowerCase();
        if ("yes".equals(playerAnswer)) return true;
        if ("no".equals(playerAnswer)) return false;
        return promptToContinue("\nВведите корректный ответ [yes / no]: ", sc);
    }
}