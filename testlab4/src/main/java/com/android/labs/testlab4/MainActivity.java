package com.android.labs.testlab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linOut = new LinearLayout(this);
        linOut.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        ViewGroup.LayoutParams lpView = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView textView = new TextView(this);
        textView.setText("TextView");
        textView.setLayoutParams(lpView);
        linOut.addView(textView);

        Button bt1 = new Button(this);
        bt1.setText("Button");
        linOut.addView(bt1, lpView);

        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50;
//        leftMarginParams.gravity = Gravity.END;
        Button bt2 = new Button(this);
        bt2.setText("Button 2");

        linOut.addView(bt2, leftMarginParams);
        setContentView(linOut, layoutParams);
    }
}