package com.android.labs.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        btnLog = findViewById(R.id.btnLogTen);

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
                Intent intentCalc = new Intent(this, Welcome.class);
                startActivity(intentCalc);
                break;
            case R.id.btnSupCalc:
                btnPowIn2.setVisibility(View.VISIBLE);
                btnLog.setVisibility(View.VISIBLE);
                break;
            case R.id.btnSimCalc:
                btnPowIn2.setVisibility(View.INVISIBLE);
                btnLog.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnZero:
                strField += "0";
                textViewField.setText(strField);
                break;
            case R.id.btnOne:
                strField += "1";
                textViewField.setText(strField);
                break;
            case R.id.btnTwo:
                strField += "2";
                textViewField.setText(strField);
                break;
            case R.id.btnThree:
                strField += "3";
                textViewField.setText(strField);
                break;
            case R.id.btnFour:
                strField += "4";
                textViewField.setText(strField);
                break;
            case R.id.btnFive:
                strField += "5";
                textViewField.setText(strField);
                break;
            case R.id.btnSix:
                strField += "6";
                textViewField.setText(strField);
                break;
            case R.id.btnSeven:
                strField += "7";
                textViewField.setText(strField);
                break;
            case R.id.btnEight:
                strField += "8";
                textViewField.setText(strField);
                break;
            case R.id.btnNine:
                strField += "9";
                textViewField.setText(strField);
                break;
            case R.id.btnAdd:
                strField += "+";
                textViewField.setText(strField);
                break;
            case R.id.btnMulty:
                strField += "*";
                textViewField.setText(strField);
                break;
            case R.id.btnSub:
                strField += "-";
                textViewField.setText(strField);
                break;
            case R.id.btnDiv:
                strField += "/";
                textViewField.setText(strField);
                break;
            case R.id.btnDot:
                if (strField.charAt(strField.length() - 1) < 48
                        || strField.charAt(strField.length() - 1) > 57 ) {
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

                break;
            case R.id.btnPowInTwo:
                strField += "^2";
                textViewField.setText(strField);
                break;
            case R.id.btnLogTen:
                strField = "ln(" + strField + ")";
                textViewField.setText(strField);
                break;
        }
    }
}