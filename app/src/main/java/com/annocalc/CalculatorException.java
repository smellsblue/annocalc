package com.annocalc;

public abstract class CalculatorException extends RuntimeException {
    public CalculatorException(String message) {
        super(message);
    }
}
