package com.android.labs.app;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringParserTest extends TestCase {

    public void testParse() {
        //20/3.1-4.54+63%3*82.2^2
        //"5+2*3-8/4/2"
        StringParser stringParser = new StringParser("20/3.1-4.54+63%3*82.2^2");
//        StringParser stringParser = new StringParser("2%3");
//        StringParser stringParser = new StringParser("5+2*3^2-8/4/2");
        List<String> operations = stringParser.parse();
        CalculationParser calculationParser = new CalculationParser(operations);
        double res = calculationParser.calculate();
//        List<Operation> operations2 = stringParser2.parse();
        List<String> str = new ArrayList<>();
//        for (String operation : operations) {
//            str.add(operation.getOperator());
//        }

    }
}