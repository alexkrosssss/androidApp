package com.android.labs.app;

public class Calculator {
    private static final int ROUND = 10000;
    public static double sum(double num1, double num2) {
        return num1 + num2;
    }
    public static double sub(double num1, double num2) {
        return num1 - num2;
    }
    public static double divide(double num1, double num2) {
        return (double) Math.round(num1 / num2 * ROUND) / ROUND;
    }
    public static double mult(double num1, double num2) {
        return (double) Math.round(num1 * num2 * ROUND) / ROUND;
    }
    public static double powInTwo(double num) {
        return num * num;
    }
    public static double per(double num) {
        return num / 100;
    }
}
