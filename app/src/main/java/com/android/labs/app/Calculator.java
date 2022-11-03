package com.android.labs.app;

public class Calculator {
    public static double sum(double num1, double num2) {
        return num1 + num2;
    }
    public static double divide(double num1, double num2) {
        return num2 != 0 ? num1 / num2 : -1;
    }
    public static double sub(double num1, double num2) {
        return num1 - num2;
    }
    public static double mult(double num1, double num2) {
        return num1 * num2;
    }
    public static double powInTwo(double num) {
        return num * num;
    }
    public static double per(double num) {
        return num / 100;
    }
}
