package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_PARTS_COUNT = 3;

    public double calculate(String expression) {
        String[] expressionParts = expression.split(" ");
        if (isExpressionPartsValid(expressionParts)) {
            String operator = expressionParts[1];
            int a = Integer.parseInt(expressionParts[0]);
            int b = Integer.parseInt(expressionParts[2]);
            return switch (operator) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> (double) a / b;
                case "%" -> Math.floorMod(a, b);
                case "^" -> Math.pow(a, b);
                default -> throw new IllegalStateException("Знак (" + operator + ") не поддерживается. " +
                        "Доступные знаки: +, -, *, /, ^, %.");
            };
        }
        return Double.NaN;
    }

    private boolean isExpressionPartsValid(String[] expressionParts) {
        if (expressionParts.length != EXPRESSION_PARTS_COUNT) {
            System.out.println("\nФормат выражения не поддерживается.");
            System.out.println("Используйте формат \"число оператор число\" через пробел и без кавычек.");
            return false;
        }
        String numbersPattern = "^-?\\d+$";
        if (!expressionParts[0].matches(numbersPattern) || !expressionParts[2].matches(numbersPattern)) {
            System.out.println("\nФормат чисел не поддерживается.");
            System.out.println("Используйте положительные/отрицательные целые числа.");
            return false;
        }
        return true;
    }
}