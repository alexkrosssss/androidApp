package com.android.labs.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.labs.app.R;

import java.lang.reflect.Method;

public class MainActivityTestModel extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button btnBack, btn1, btn2, btn3, btn4;

    private static final String TAG = "testLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_equations);
        textView =  findViewById(R.id.textView);
        btnBack = findViewById(R.id.btnBack);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);


        btnBack.setOnClickListener(this::onClick);
        btn1.setOnClickListener(this::onClick);
        btn2.setOnClickListener(this::onClick);
        btn3.setOnClickListener(this::onClick);
        btn4.setOnClickListener(this::onClick);
        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
        registerForContextMenu(btn3);
        registerForContextMenu(btn4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Button btn;

        Method[] declaredMethods = item.getClass().getClass().getDeclaredMethods();
        if (item.getActionProvider() != null) {
            textView.setText("not null");
        } else {
            textView.setText("null");
        }
        switch (item.getItemId()) {
            case R.id.conMenuColorRed:
                textView.setText("back button is red color");
//                btn = findViewById(item.getActionView().getId());
                btnBack.setBackgroundColor(Color.RED);
                break;
            case R.id.conMenuColorBlue:
                textView.setText("back button is blue color");
//                btn = findViewById(item.getActionView().getId());
                btnBack.setBackgroundColor(Color.BLUE);
                break;
            case R.id.conMenuColorGreen:
                textView.setText("back button is green color");
//                btn = findViewById(item.getActionView().getId());
                btnBack.setBackgroundColor(Color.GREEN);
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        switch (item.getItemId()) {
            case R.id.menuCloseProgram:
                System.exit(1);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        Log.d(TAG, "define button that invoked parser");
        switch (view.getId()) {
            case R.id.btn1:
                Log.d(TAG, "button 1 pressed");
                textView.setText(R.string.textBtn1);
                break;
            case R.id.btn2:
                Log.d(TAG, "button 2 pressed");
                textView.setText(R.string.textBtn2);
                break;
            case R.id.btn3:
                Log.d(TAG, "button 3 pressed");
                textView.setText(R.string.textBtn3);
                break;
            case R.id.btn4:
                Log.d(TAG, "button 4 pressed");
                textView.setText(R.string.textBtn4);
                break;
            case R.id.btnBack:
                Log.d(TAG, "button Back pressed");;
                textView.setText(R.string.textBtnBack);
                break;
        }
    }
}