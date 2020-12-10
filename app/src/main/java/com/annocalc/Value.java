package com.annocalc;

public class Value {
    private final Number value;

    public Value(Number value) {
        this.value = value;
    }

    public int toInteger() {
        return value.intValue();
    }

    public double toDouble() {
        return value.doubleValue();
    }

    @Override
    public String toString() {
        return "" + toDouble();
    }

    @Operation("q")
    public static void quit() {
        System.out.println("Thank you for calculating with me!");
        System.exit(0);
    }

    @Operation("+")
    public Value add(Value other) {
        return new Value(toDouble() + other.toDouble());
    }

    @Operation("-")
    public Value subtract(Value other) {
        return new Value(toDouble() - other.toDouble());
    }

    @Operation("*")
    public Value multiply(Value other) {
        return new Value(toDouble() * other.toDouble());
    }

    @Operation("/")
    public Value divide(Value other) {
        return new Value(toDouble() / other.toDouble());
    }
}
