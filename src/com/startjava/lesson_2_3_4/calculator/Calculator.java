package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private String operator;

    public boolean isExpressionValid(String input) {
        String[] expression = input.trim().replaceAll("\\s+", " ").split(" ");
        if (expression.length != 3) {
            System.out.println("\nДанный формат выражения не поддерживается.");
            System.out.println("Для ввода используйте формат \"число оператор число\" через пробел и без кавычек.");
            System.out.println("Пример: \"21 / 7\" и еще один: \"-9 * 31\".");
            return false;
        }
        String numbersPattern = "^-?\\d+$";
        if (!expression[0].matches(numbersPattern) || !expression[2].matches(numbersPattern)) {
            System.out.println("\nДанный формат чисел не поддерживается.");
            System.out.println("Доступны положительные/отрицательные целые числа.");
            return false;
        }
        operator = expression[1];
        firstNumber = Integer.parseInt(expression[0]);
        secondNumber = Integer.parseInt(expression[2]);
        return true;
    }

    public String getExpression() {
        return firstNumber + " " + operator + " " + secondNumber;
    }

    public double calculate() {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> (double) firstNumber / secondNumber;
            case "%" -> Math.floorMod(firstNumber, secondNumber);
            case "^" -> Math.pow(firstNumber, secondNumber);
            default -> throw new IllegalStateException(
                    "Операция (" + operator + ") не поддерживается. Доступны следующие операции: +, -, *, /, ^, %."
            );
        };
    }
}