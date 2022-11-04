package com.android.labs.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBack, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnEqual,
            btnAdd, btnSub, btnMulty, btnDiv, btnDot, btnErase, btnEraseChar, btnSupCalc,
            btnPowIn2, btnLog, btnSimCalc;
    TextView textViewField;
    String strField = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initUI();
    }
    public void initUI(){
        textViewField = findViewById(R.id.textViewField);
        btnBack = findViewById(R.id.btnMoveToMain);
        btnSimCalc = findViewById(R.id.btnSimCalc);
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);
        btn0 = findViewById(R.id.btnZero);
        btnAdd = findViewById(R.id.btnAdd);
        btnMulty = findViewById(R.id.btnMulty);
        btnDiv = findViewById(R.id.btnDiv);
        btnSub = findViewById(R.id.btnSub);
        btnErase = findViewById(R.id.btnErase);
        btnEraseChar = findViewById(R.id.btnEraseChar);
        btnEqual = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);
        btnSupCalc = findViewById(R.id.btnSupCalc);
        btnPowIn2 = findViewById(R.id.btnPowInTwo);
        btnLog = findViewById(R.id.btnPer);

        btnBack.setOnClickListener(this::onClick);
        btnSimCalc.setOnClickListener(this::onClick);
        btnAdd.setOnClickListener(this::onClick);
        btnMulty.setOnClickListener(this::onClick);
        btnDiv.setOnClickListener(this::onClick);
        btnSub.setOnClickListener(this::onClick);
        btnErase.setOnClickListener(this::onClick);
        btnEraseChar.setOnClickListener(this::onClick);
        btnEqual.setOnClickListener(this::onClick);
        btnDot.setOnClickListener(this::onClick);
        btnSupCalc.setOnClickListener(this::onClick);
        btnPowIn2.setOnClickListener(this::onClick);
        btnLog.setOnClickListener(this::onClick);
        btn0.setOnClickListener(this::onClick);
        btn1.setOnClickListener(this::onClick);
        btn2.setOnClickListener(this::onClick);
        btn3.setOnClickListener(this::onClick);
        btn4.setOnClickListener(this::onClick);
        btn5.setOnClickListener(this::onClick);
        btn6.setOnClickListener(this::onClick);
        btn7.setOnClickListener(this::onClick);
        btn8.setOnClickListener(this::onClick);
        btn9.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnMoveToMain:
//                finish();
                Intent intentCalc = new Intent(this, Welcome.class);
                startActivity(intentCalc);
                break;
            case R.id.btnSupCalc:
                Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
                btnPowIn2.setVisibility(View.VISIBLE);
                btnLog.setVisibility(View.VISIBLE);
                btnPowIn2.startAnimation(anim);
                btnLog.startAnimation(anim);
                break;
            case R.id.btnSimCalc:
                Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.reverse_alpha);
                btnPowIn2.setVisibility(View.INVISIBLE);
                btnLog.setVisibility(View.INVISIBLE);
                btnLog.startAnimation(anim2);
                btnPowIn2.startAnimation(anim2);
                break;
            case R.id.btnZero:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "0";
                textViewField.setText(strField);
                break;
            case R.id.btnOne:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "1";
                textViewField.setText(strField);
                break;
            case R.id.btnTwo:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "2";
                textViewField.setText(strField);
                break;
            case R.id.btnThree:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "3";
                textViewField.setText(strField);
                break;
            case R.id.btnFour:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "4";
                textViewField.setText(strField);
                break;
            case R.id.btnFive:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "5";
                textViewField.setText(strField);
                break;
            case R.id.btnSix:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "6";
                textViewField.setText(strField);
                break;
            case R.id.btnSeven:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "7";
                textViewField.setText(strField);
                break;
            case R.id.btnEight:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "8";
                textViewField.setText(strField);
                break;
            case R.id.btnNine:
                if (strField.endsWith(StringParser.PERCENT)) {
                    strField += "*";
                }
                strField += "9";
                textViewField.setText(strField);
                break;
            case R.id.btnAdd:
                if (strField.length() == 0) {
                    strField += "0";
                }
                //allow replace operator to new if operator placed early
                if (isOperator(strField.substring(strField.length() - 1))) {
                    strField = strField.substring(0, strField.length() - 1) + "+";
                } else {
                    strField += "+";
                }
                textViewField.setText(strField);
                break;
            case R.id.btnMulty:
                if (strField.length() == 0) {
                    strField += "0";
                }
                //allow replace operator to new if operator placed early
                if (isOperator(strField.substring(strField.length() - 1))) {
                    strField = strField.substring(0, strField.length() - 1) + "*";
                } else {
                    strField += "*";
                }
                textViewField.setText(strField);
                break;
            case R.id.btnSub:
                //allow replace operator to new if operator placed early
                if (strField.length() > 1 && isOperator(strField.substring(strField.length() - 1))) {
                    strField = strField.substring(0, strField.length() - 1) + "-";
                } else {
                    strField += "-";
                }
                textViewField.setText(strField);
                break;
            case R.id.btnDiv:
                if (strField.length() == 0) {
                    strField += "0";
                }
                //allow replace operator to new if operator placed early
                if (isOperator(strField.substring(strField.length() - 1))) {
                    strField = strField.substring(0, strField.length() - 1) + "/";
                } else {
                    strField += "/";
                }
                textViewField.setText(strField);
                break;
            case R.id.btnDot:
                if (strField.charAt(strField.length() - 1) < 48
                        || strField.charAt(strField.length() - 1) > 57
                        || strField.length() == 0) {
                    strField += "0";
                }
                strField += ".";
                textViewField.setText(strField);
                break;
            case R.id.btnEraseChar:
                strField = strField.substring(0, strField.length() - 1);
                textViewField.setText(strField);
                break;
            case R.id.btnErase:
                strField = "";
                textViewField.setText(strField);
                break;
            case R.id.btnEqual:
                StringParser parser = new StringParser(strField);
                ArrayList<String> operations = parser.parse();
                CalculationParser calculationParser = new CalculationParser(operations);
                try {
                    String result = calculationParser.calculate();
                    strField = result;
                    textViewField.setText(strField);

                } catch (IndexOutOfBoundsException e) {
                    strField = "";
                    textViewField.setText("ERROR");
                } catch (Exception e) {
                    strField = "";
                    textViewField.setText("ERROR");
                }
                break;
            case R.id.btnPowInTwo:
                if (strField.length() == 0) {
                    strField += "0";
                }
                //allow replace operator to new if operator placed early
                if (isOperator(strField.substring(strField.length() - 1))) {
                    strField = strField.substring(0, strField.length() - 1) + "^2";
                } else {
                    strField += "^2";
                }
                textViewField.setText(strField);
                break;
            case R.id.btnPer:
                if (strField.length() == 0) {
                    strField += "0";
                }
                //allow replace operator to new if operator placed early
                if (isOperator(strField.substring(strField.length() - 1))) {
                    strField = strField.substring(0, strField.length() - 1) + "%";
                } else {
                    strField += "%";
                }
                textViewField.setText(strField);
                break;
        }

    }
    private boolean isOperator(String operator){
        boolean result = false;
        switch(operator) {
            case StringParser.POW_IN_TWO:
            case StringParser.SUBTRACTION:
            case StringParser.PERCENT:
            case StringParser.ADDITION:
            case StringParser.DIVISION:
            case StringParser.MULTIPLICATION:
                result = true;
                break;
        }
        return result;
    }
}