package com.annocalc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Operator {
    private final String operation;
    private final Method method;
    private final boolean voidReturn;
    private final boolean staticMethod;
    private final int arity;

    public Operator(Method method) {
        this.operation = method.getAnnotation(Operation.class).value();
        this.method = method;
        this.voidReturn = method.getReturnType().equals(Void.TYPE);
        this.staticMethod = Modifier.isStatic(method.getModifiers());

        if (staticMethod) {
            this.arity = method.getParameterCount();
        } else {
            this.arity = method.getParameterCount() + 1;
        }
    }

    public boolean isVoid() {
        return voidReturn;
    }

    public boolean isStatic() {
        return staticMethod;
    }

    public int getArity() {
        return arity;
    }

    public Value operate(Value... values) {
        try {
            if (values.length != arity) {
                throw new IllegalArgumentException("Expected " + arity + " values, got " + values.length);
            }

            Value object;
            Object[] rest;

            if (isStatic()) {
                object = null;
                rest = values;
            } else {
                object = values[0];
                rest = Arrays.copyOfRange(values, 1, values.length);
            }

            return (Value) method.invoke(object, rest);
        } catch (IllegalAccessException|InvocationTargetException e) {
            throw new RuntimeException("Problem invoking " + operation, e);
        }
    }
}
