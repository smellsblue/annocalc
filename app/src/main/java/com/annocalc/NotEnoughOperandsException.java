package com.annocalc;

public class NotEnoughOperandsException extends CalculatorException {
    public NotEnoughOperandsException(String operator, int available, int required) {
        super("Not enough operands for '" + operator + "' (got " + available + ", need " + required + ")");
    }
}
