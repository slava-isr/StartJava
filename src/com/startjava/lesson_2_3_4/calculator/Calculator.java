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

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate() {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> (double) firstNumber / secondNumber;
            case "%" -> Math.floorMod(firstNumber, secondNumber);
            case "^" -> Math.pow(firstNumber, secondNumber);
            default -> throw new IllegalStateException("Неизвестный оператор: " + operator);
        };
    }
}