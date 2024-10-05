package com.startjava.lesson_1.final_;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\"\n");
        System.out.println("Будьте внимательны - программа работает только с натуральными числами");
        System.out.println("Допустимые операторы для использования: +, -, *, /, ^, %\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int firstNumber = inputNumber(sc);
        System.out.print("Введите оператор: ");
        String operator = inputOperator(sc);
        System.out.print("Введите второе число: ");
        int secondNumber = inputNumber(sc);
        int result = calculate(firstNumber, operator, secondNumber);
        System.out.printf("%n%d %s %d = %d", firstNumber, operator, secondNumber, result);
        sc.close();
    }

    private static int inputNumber(Scanner sc) {
        int number;
        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0) break;
            }
            System.out.print("Неправильный формат! Попробуйте снова: ");
            sc.nextLine();
        }
        return number;
    }

    private static String inputOperator(Scanner sc) {
        String operator;
        while (true) {
            operator = sc.next();
            if (operator.equals("+")
                    || operator.equals("-")
                    || operator.equals("*")
                    || operator.equals("/")
                    || operator.equals("^")
                    || operator.equals("%")) {
                break;
            }
            System.out.print("Неправильный оператор! Попробуйте снова: ");
            sc.nextLine();
        }
        return operator;
    }

    private static int calculate(int firstNumber, String operator, int secondNumber) {
        int result = firstNumber;
        if (operator.equals("+")) {
            result += secondNumber;
        } else if (operator.equals("-")) {
            result -= secondNumber;
        } else if (operator.equals("*")) {
            result *= secondNumber;
        } else if (operator.equals("/")) {
            result /= secondNumber;
        } else if (operator.equals("%")) {
            result %= secondNumber;
        } else {
            for (int i = 1; i < secondNumber; i++) {
                result *= firstNumber;
            }
        }
        return result;
    }
}