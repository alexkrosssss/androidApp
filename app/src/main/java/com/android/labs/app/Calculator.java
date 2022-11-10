package com.android.labs.app;

public class Calculator {
    public static final int ROUND = 10000;
    public static double sum(double num1, double num2) {
        return num1 + num2;
    }
    public static double sub(double num1, double num2) {
        return num1 - num2;
    }
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Divided by zero");
        }
        return num1 / num2;
//        return (double) Math.round(num1 / num2 * ROUND) / ROUND;
    }
    public static double mult(double num1, double num2) {
        return num1 * num2;
//        return (double) Math.round(num1 * num2 * ROUND) / ROUND;
    }
    public static double powInTwo(double num) {
        return num * num;
    }
    public static double per(double num) {
        return num / 100;
    }
}
