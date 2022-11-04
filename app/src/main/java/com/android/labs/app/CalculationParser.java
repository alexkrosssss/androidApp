package com.android.labs.app;

import java.util.List;

public class CalculationParser {
    private List<String> sequence;
    private int countPow = 0;
    private int countSum = 0;
    private int countDiv = 0;
    private int countSub = 0;
    private int countMult = 0;
    private int countPer = 0;
    public CalculationParser() {
    }

    public CalculationParser(List<String> sequence) {
        this.sequence = sequence;
    }

    public String calculate(){
        calcCount();
        calcPow();
        calcPer();
        calcMult();
        calcDiv();
        calcSum();
        calcSub();
        String result = sequence.get(0);
        if (result.endsWith(".0")) {
            result = result.substring(0,result.length()-2);
        }
        return result;
    }

    private void calcCount(){
        for (String el : sequence) {
            switch(el) {
                case StringParser.POW_IN_TWO:
                    countPow++;
                    break;
                case StringParser.PERCENT:
                    countPer++;
                    break;
                case StringParser.ADDITION:
                    countSum++;
                    break;
                case StringParser.SUBTRACTION:
                    countSub++;
                    break;
                case StringParser.DIVISION:
                    countDiv++;
                    break;
                case StringParser.MULTIPLICATION:
                    countMult++;
                    break;
            }
        }
    }

    private void calcPow(){
        for (int i = 0; i < countPow; i++) {
            for (int j = 1; j < sequence.size(); j++) {
                if (sequence.get(j).equals(StringParser.POW_IN_TWO)) {
                    double number1 = Double.parseDouble(sequence.get(j - 1));
                    double result = Calculator.powInTwo(number1);
                    sequence.remove(j - 1);
                    sequence.remove(j - 1);
                    sequence.set(j - 1, String.valueOf(result));
                    break;
                }
            }
        }
    }

    private void calcSum(){
        for (int i = 0; i < countSum; i++) {
            for (int j = 1; j < sequence.size(); j++) {
                if (sequence.get(j).equals(StringParser.ADDITION)) {
                    double number1 = Double.parseDouble(sequence.get(j - 1));
                    double number2 = Double.parseDouble(sequence.get(j + 1));
                    double result = Calculator.sum(number1, number2);
                    sequence.remove(j - 1);
                    sequence.remove(j - 1);
                    sequence.set(j - 1, String.valueOf(result));
                    break;
                }
            }
        }
    }

    private void calcSub(){
        for (int i = 0; i < countSub; i++) {
            for (int j = 1; j < sequence.size(); j++) {
                if (sequence.get(j).equals(StringParser.SUBTRACTION)) {
                    double number1 = Double.parseDouble(sequence.get(j - 1));
                    double number2 = Double.parseDouble(sequence.get(j + 1));
                    double result = Calculator.sub(number1, number2);
                    sequence.remove(j - 1);
                    sequence.remove(j - 1);
                    sequence.set(j - 1, String.valueOf(result));
                    break;
                }
            }
        }
    }

    private void calcMult(){
        for (int i = 0; i < countMult; i++) {
            for (int j = 1; j < sequence.size(); j++) {
                if (sequence.get(j).equals(StringParser.MULTIPLICATION)) {
                    double number1 = Double.parseDouble(sequence.get(j - 1));
                    double number2 = Double.parseDouble(sequence.get(j + 1));
                    double result = Calculator.mult(number1, number2);
                    sequence.remove(j - 1);
                    sequence.remove(j - 1);
                    sequence.set(j - 1, String.valueOf(result));
                    break;
                }
            }
        }
    }

    private void calcDiv(){
        for (int i = 0; i < countDiv; i++) {
            for (int j = 1; j < sequence.size(); j++) {
                if (sequence.get(j).equals(StringParser.DIVISION)) {
                    double number1 = Double.parseDouble(sequence.get(j - 1));
                    double number2 = Double.parseDouble(sequence.get(j + 1));
                    double result = Calculator.divide(number1, number2);
                    sequence.remove(j - 1);
                    sequence.remove(j - 1);
                    sequence.set(j - 1, String.valueOf(result));
                    break;
                }
            }
        }
    }


    private void calcPer(){
        for (int i = 0; i < countPer; i++) {
            for (int j = 1; j < sequence.size(); j++) {
                if (sequence.get(j).equals(StringParser.PERCENT)) {
                    double number1 = Double.parseDouble(sequence.get(j - 1));
                    double result = Calculator.per(number1);
                    sequence.remove(j - 1);
                    sequence.set(j - 1, String.valueOf(result));
                    break;
                }
            }
        }
    }
}
