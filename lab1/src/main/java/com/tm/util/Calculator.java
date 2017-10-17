package com.tm.util;

/**
 * Created by tudor.maier on 17/10/2017.
 */
public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int substract(int a, int b) {
        return a - b;
    }

    public static double divide(double a, double b) throws Exception {
        if (!Double.valueOf(0.0).equals(Double.valueOf(b))) {
            return a / b;
        }
        throw new Exception("Division by zero");
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static double sqrt(int a) throws Exception {
        if ( a >= 0 ) {
            return Math.sqrt(a);
        }
        throw new Exception("Negative argument");
    }
}
