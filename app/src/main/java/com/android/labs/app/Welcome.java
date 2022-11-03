package com.android.labs.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    Button btnLevel;
    Button btnCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnLevel = findViewById(R.id.btnLevels);
        btnCalc = findViewById(R.id.btnCalc);
        btnLevel.setOnClickListener(this::onClick);
        btnCalc.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCalc:
                Intent intentCalc = new Intent(this, CalculatorActivity.class);
                startActivity(intentCalc);
                break;
            case R.id.btnLevels:
                Intent intentLev = new Intent(this, MainActivityTestModel.class);
                startActivity(intentLev);
                break;
        }
    }
}