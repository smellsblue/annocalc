/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.annocalc;

import java.io.Console;
import java.util.regex.Pattern;

public class App {
    private static final Pattern NUMBER = Pattern.compile("\\A-?\\d+(?:\\.\\d+)?\\z");

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Console console = System.console();

        while (true) {
            System.out.print("> ");
            String line = console.readLine().trim();

            try {
                if (NUMBER.matcher(line).matches()) {
                    calc.push(Double.valueOf(line));
                } else {
                    calc.operate(line);
                }

                System.out.println(calc.peek());
            } catch (CalculatorException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
