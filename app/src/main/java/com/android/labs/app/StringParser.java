package com.android.labs.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public final static String ADDITION = "+";
    public final static String SUBTRACTION = "-";
    public final static String MULTIPLICATION = "*";
    public final static String DIVISION = "/";
    public final static String POW_IN_TWO = "^";
    public final static String POW_IN_TWO_2 = "^2";
    public final static String PERCENT = "%";

    private final static String OPERATORS_AND_DIGITS = "^-[0-9]+[.][0-9]+|^-[0-9]+|[\\-+*/^%]|[0-9]+[.][0-9]+|[0-9]+";
//    private final static String DIGITS = "";

    private String originalString;

    private ArrayList<String> sequenceOperation = new ArrayList<>();




    public StringParser(String originalString) {
        this.originalString = originalString;
    }

    public ArrayList<String> parse() {
        Pattern patternOperatorsAndDigits = Pattern.compile(OPERATORS_AND_DIGITS);
        //Pattern patternDigits = Pattern.compile(DIGITS);

        Matcher matcherOperatorsAndDigits = patternOperatorsAndDigits.matcher(originalString);
//        Matcher matcherDigits = patternDigits.matcher(originalString);

        List<Integer> arrayIndexOfOperators = new ArrayList<>();
        List<Integer> arrayIndexOfDigits = new ArrayList<>();
        while (matcherOperatorsAndDigits.find()) {
            sequenceOperation.add(matcherOperatorsAndDigits.group());
        }

        return sequenceOperation;
    }
}
