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
            inputExpression(calculator, sc);
            printFormattedResult(calculator.getFirstNumber(), calculator.getOperator(),
                    calculator.getSecondNumber(), calculator.calculate());
        } while (promptToContinue("\nХотите продолжить вычисления? [yes/no]: ", sc));
        System.out.println("\nДо свидания!");
        sc.close();
    }

    private static void inputExpression(Calculator calculator, Scanner sc) {
        System.out.print("\nВведите математическое выражение: ");
        String[] expression = sc.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        if (!getValidatedExpression(expression)) {
            inputExpression(calculator, sc);
        } else {
            calculator.setFirstNumber(Integer.parseInt(expression[0]));
            calculator.setOperator(expression[1]);
            calculator.setSecondNumber(Integer.parseInt(expression[2]));
        }
    }

    private static boolean getValidatedExpression(String[] expression) {
        if (expression.length != 3) {
            System.out.println("\nДанный формат выражения (" + String.join(" ", expression) + ") не поддерживается.");
            System.out.println("Для ввода используйте формат \"число оператор число\" через пробел и без кавычек.");
            System.out.println("Пример: \"21 / 7\" и еще один: \"-9 * 31\".");
            return false;
        }
        String numbersPattern = "^-?\\d+$";
        if (!expression[0].matches(numbersPattern)) {
            System.out.println("\nФормат первого числа (" + expression[0] + ") не поддерживается.");
            System.out.println("Доступны положительные/отрицательные целые числа.");
            return false;
        }
        String operatorPattern = "^[+\\-*/^%]$";
        if (!expression[1].matches(operatorPattern)) {
            System.out.println("\nОшибка: операция (" + expression[1] + ") не поддерживается.");
            System.out.println("Доступны следующие операции: +, -, *, /, ^, %.");
            return false;
        }
        if (!expression[2].matches(numbersPattern)) {
            System.out.println("\nФормат второго числа (" + expression[2] + ") не поддерживается.");
            System.out.println("Доступны положительные/отрицательные целые числа.");
            return false;
        }
        return true;
    }

    private static void printFormattedResult(int firstNumber, String operator, int secondNumber, double result) {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            System.out.println(secondNumber == 0 ?
                    "\nДеление на ноль запрещено." :
                    "\nУпс! Получено недопустимое значение. Проверьте выражение и попробуйте снова.");
            return;
        }
        DecimalFormat df = new DecimalFormat("#.####");
        String formattedResult = df.format(result);
        System.out.printf("%n%d %s %d = %s%n", firstNumber, operator, secondNumber, formattedResult);
    }

    private static boolean promptToContinue(String message, Scanner sc) {
        System.out.print(message);
        String playerAnswer = sc.nextLine().trim().toLowerCase();
        if ("yes".equals(playerAnswer)) return true;
        if ("no".equals(playerAnswer)) return false;
        return promptToContinue("\nВведите корректный ответ [yes / no]: ", sc);
    }
}