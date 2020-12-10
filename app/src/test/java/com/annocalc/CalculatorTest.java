package com.annocalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void pushAndPeek() {
        Calculator calc = new Calculator();
        calc.push(40);
        assertEquals(40, calc.peek().toInteger());
        assertEquals(40, calc.peek().toInteger());
        calc.push(2);
        assertEquals(2, calc.peek().toInteger());
        assertEquals(2, calc.peek().toInteger());
    }

    @Test
    public void simpleAdd() {
        Calculator calc = new Calculator();
        calc.push(40);
        calc.push(2);
        calc.operate("+");
        assertEquals(42, calc.peek().toInteger());
    }

    @Test
    public void simpleSubtract() {
        Calculator calc = new Calculator();
        calc.push(44);
        calc.push(2);
        calc.operate("-");
        assertEquals(42, calc.peek().toInteger());
    }

    @Test
    public void simpleDivide() {
        Calculator calc = new Calculator();
        calc.push(84);
        calc.push(2);
        calc.operate("/");
        assertEquals(42, calc.peek().toInteger());
    }
}
