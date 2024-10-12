package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private String operator;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public boolean setOperator(String operator) {
        return switch (operator) {
            case "+", "-", "*", "/", "^", "%" -> {
                this.operator = operator;
                yield true;
            }
            default -> false;
        };
    }

    public double calculate() {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> div();
            case "%" -> mod();
            case "^" -> pow();
            default -> throw new IllegalStateException("Неизвестный оператор: " + operator);
        };
    }

    private double div() {
        isZero();
        return (double) firstNumber / secondNumber;
    }

    private double mod() {
        isZero();
        return (double) firstNumber % secondNumber;
    }

    private void isZero() {
        if (secondNumber == 0) System.out.println("\nОшибка: деление на ноль запрещено");
    }

    private double pow() {
        int result = firstNumber;
        for (int i = 1; i < Math.abs(secondNumber); i++) {
            result *= firstNumber;
        }
        return secondNumber < 0 ? 1. / result : result;
    }
}