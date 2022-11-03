package com.android.labs.app;

class Operation {
    private double number1;
    private double number2;
    private String operator;

    public Operation(){

    }

    public Operation(double number1, double number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public String getOperator() {
        return operator;
    }

}
