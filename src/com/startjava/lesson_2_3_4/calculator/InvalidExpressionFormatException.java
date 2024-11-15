package com.startjava.lesson_2_3_4.calculator;

public class InvalidExpressionFormatException extends RuntimeException {
    public InvalidExpressionFormatException(String message) {
        super(message);
    }
}