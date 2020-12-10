package com.annocalc;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Deque<Value> stack = new ArrayDeque<>();
    private Map<String, Operator> operations;

    public void push(Number value) {
        stack.push(new Value(value));
    }

    public Value peek() {
        return stack.peek();
    }

    public void operate(String operation) {
        Operator operator = getOperator(operation);

        if (stack.size() < operator.getArity()) {
            throw new NotEnoughOperandsException(operation, stack.size(), operator.getArity());
        }

        Value[] operands = new Value[operator.getArity()];

        for (int i = operands.length - 1; i >= 0; i--) {
            operands[i] = stack.pop();
        }

        Value result = operator.operate(operands);

        if (!operator.isVoid()) {
            stack.push(result);
        }
    }

    private Operator getOperator(String operation) {
        if (operations == null) {
            operations = new HashMap<>();

            for (Method method : Value.class.getDeclaredMethods()) {
                Operation op = method.getAnnotation(Operation.class);

                if (op != null) {
                    operations.put(op.value(), new Operator(method));
                }
            }
        }

        Operator result = operations.get(operation);

        if (result == null) {
            throw new OperatorNotFoundException(operation);
        }

        return result;
    }
}
