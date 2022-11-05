package com.android.labs.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.labs.app.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivityTestModel extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button btnBack, btn1, btn2, btn3, btn4;
    LinearLayout llMain;
    int countButton = 0;
    Map<Integer, Integer> buttonMap = new HashMap<>();
    Map<Integer, Integer> textButtonMap = new HashMap<>();
    private static final String TAG = "testLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_equations);
        textView =  findViewById(R.id.textView);
        btnBack = findViewById(R.id.btnBack);

        llMain = findViewById(R.id.llMain);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btnBack.setOnClickListener(this::onClick);


        Field[] xmlStrings = R.string.class.getDeclaredFields();
        for (Field xmlString: xmlStrings) {
            Integer i = new Integer(0);
            int a=0;
            try {
                a=xmlString.getInt(i);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            String[] strs = xmlString.toString().split("\\.");
            String name = strs[strs.length - 1];
            if (name.substring(0, name.length() - 1).equals("btn")) {
                buttonMap.put(Integer.parseInt(name.substring(name.length() - 1)), a);
            } else if (name.substring(0, name.length() - 2).equals("btn")) {
                buttonMap.put(Integer.parseInt(name.substring(name.length() - 2)), a);
            } else if (name.substring(0, name.length() - 1).equals("textBtn")) {
                textButtonMap.put(Integer.parseInt(name.substring(name.length() - 1)), a);
            } else if (name.substring(0, name.length() - 2).equals("textBtn")) {
                textButtonMap.put(Integer.parseInt(name.substring(name.length() - 2)), a);
            }
        }
        countButton++;
        btn1.setId(buttonMap.get(countButton));
        countButton++;
        btn2.setId(buttonMap.get(countButton));
        countButton++;
        btn3.setId(buttonMap.get(countButton));
        countButton++;
        btn4.setId(buttonMap.get(countButton));
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
    LinearLayout linearLayout;
    LinearLayout.LayoutParams lParams;
    LinearLayout.LayoutParams lParams2;
    private Toast showToast;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (showToast != null) {
            showToast.cancel();
        }
        switch (item.getItemId()) {
            case R.id.menuCreateLevel:
                if (countButton >= 20) {
                    showToast = Toast.makeText(this, "You create max number levels", Toast.LENGTH_LONG);
                    showToast.show();
                }
                else {
                    showToast = Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT);
                    showToast.show();

                    Button bt = new Button(this);
                    bt.setId(buttonMap.get(countButton+1));
                    bt.setText(buttonMap.get(countButton+1));
                    bt.setBackgroundColor(getResources().getColor(R.color.newColor));
                    bt.setTextColor(getResources().getColor(R.color.white));
                    bt.setTextSize(18);

                    bt.setOnClickListener(this::onClick);
                    registerForContextMenu(bt);

                    if (countButton % 4 == 0) {
                        linearLayout = new LinearLayout(this);
                        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                        lParams = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT);
//                        lParams.weight = 1;
                        lParams.setMargins(15, 10, 15, 10);
                        lParams2 = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT);
                        lParams2.setMargins(0, 0, 0, 20);
//                        lParams2.weight = 1;
                        linearLayout.addView(bt, lParams);
                        llMain.addView(linearLayout,lParams2);
                    } else {
                        linearLayout.addView(bt, lParams);
                    }
                    countButton++;
                    Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
                    bt.startAnimation(anim);
                }
                break;
            case R.id.menuClearLevels:
                llMain.removeAllViews();
                countButton = 4;
                showToast = Toast.makeText(this, "new levels have deleted", Toast.LENGTH_SHORT);
                showToast.show();
                break;
            case R.id.menuCloseProgram:
                finishAffinity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        Log.d(TAG, "define button that invoked parser");

        int idView = view.getId();
        if (idView == R.id.btnBack){
            Intent intent = new Intent(this, Welcome.class);
            startActivity(intent);
        } else {
            for (Map.Entry<Integer, Integer> entry : buttonMap.entrySet()) {
                if (idView == entry.getValue()) {

                    textView.setText(textButtonMap.get(entry.getKey()));
                    Log.d(TAG, "" + textButtonMap.get(entry.getKey()));;
                    break;
                }
            }
        }
    }
}