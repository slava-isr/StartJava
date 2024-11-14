package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\".");
        System.out.println("Будьте внимательны - программа работает только с целыми числами.");
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        String userAnswer = "yes";
        while (!"no".equals(userAnswer)) {
            if ("yes".equals(userAnswer)) {
                System.out.print("\nВведите выражение из трех аргументов, например, 2 ^ 10: ");
                String expression = sc.nextLine().trim().replaceAll("\\s+", " ");
                printFormattedResult(expression, calculator.calculate(expression));
                System.out.print("\nХотите продолжить вычисления? [yes / no]: ");
            } else System.out.print("\nВведите корректный ответ [yes / no]: ");
            userAnswer = sc.nextLine().trim().toLowerCase();
        }
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
    }
}