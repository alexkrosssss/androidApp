package com.android.labs.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    Button btnLevel;
    Button btnCalc;
    Button btnExit;
    private long timePress;
    private Toast showToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnLevel = findViewById(R.id.btnLevels);
        btnCalc = findViewById(R.id.btnCalc);
        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this::onClick);
        btnLevel.setOnClickListener(this::onClick);
        btnCalc.setOnClickListener(this::onClick);
    }

    @Override
    public void onBackPressed() {
        if (timePress + 2000 > System.currentTimeMillis()) {
            showToast.cancel();
            super.onBackPressed();
            return;
        } else {
            showToast = Toast.makeText(getBaseContext(), "Press one more time for exit", Toast.LENGTH_SHORT);
            showToast.show();
        }
        timePress = System.currentTimeMillis();
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
            case R.id.btnExit:
                finishAffinity();
                break;
        }
    }
}