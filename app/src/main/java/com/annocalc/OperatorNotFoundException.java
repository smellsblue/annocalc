package com.annocalc;

public class OperatorNotFoundException extends CalculatorException {
    public OperatorNotFoundException(String operator) {
        super("Unknown operator: '" + operator + "'");
    }
}
