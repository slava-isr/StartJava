package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\".");
        System.out.println("Будьте внимательны - программа работает только с целыми числами.");
        Scanner sc = new Scanner(System.in);
        String userAnswer = "yes";
        launchCalculator(userAnswer, sc);
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static void launchCalculator(String userAnswer, Scanner sc) {
        while (!"no".equals(userAnswer)) {
            if ("yes".equals(userAnswer)) {
                System.out.print("\nВведите выражение из трех аргументов, например, 2 ^ 10: ");
                String expression = sc.nextLine().trim().replaceAll("\\s+", " ");
                try {
                    printFormattedResult(expression, Calculator.calculate(expression));
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("\nХотите продолжить вычисления? [yes / no]: ");
            } else System.out.print("\nВведите корректный ответ [yes / no]: ");
            userAnswer = sc.nextLine().trim().toLowerCase();
        }
    }

    private static void printFormattedResult(String expression, double result) {
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.printf("%n%s = %s%n", expression, df.format(result));
    }
}