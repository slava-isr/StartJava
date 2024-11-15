package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_PARTS_COUNT = 3;

    public static double calculate(String expression) {
        String[] expressionParts = expression.split(" ");
        if (expressionParts.length != EXPRESSION_PARTS_COUNT) {
            throw new InvalidExpressionFormatException("\nНеправильный формат. Введите: число оператор число.");
        }
        String operator = expressionParts[1];
        int a;
        int b;
        try {
            a = Integer.parseInt(expressionParts[0]);
            b = Integer.parseInt(expressionParts[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("\nОшибка: введите целые числа.");
        }
        if (b == 0 && ("/".equals(operator) || "%".equals(operator))) {
            throw new ArithmeticException("\nОшибка: деление на ноль.");
        }
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> (double) a / b;
            case "%" -> Math.floorMod(a, b);
            case "^" -> Math.pow(a, b);
            default -> throw new UnsupportedOperatorException("\nОператор \"" + operator + "\" не поддерживается." +
                    "\nИспользуйте: +, -, *, /, ^, %.");
        };
    }
}