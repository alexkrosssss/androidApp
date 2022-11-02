package com.android.labs.labs1_4;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;
    final int MENU_MENU_SIZE_22 = 4;
    final int MENU_MENU_SIZE_26 = 5;
    final int MENU_MENU_SIZE_30 = 6;
    TextView viewColor, viewSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        viewColor = findViewById(R.id.textViewColor);
        viewSize = findViewById(R.id.textViewSize);
        registerForContextMenu(viewColor);
        registerForContextMenu(viewSize);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.textViewColor:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
            case R.id.textViewSize:
                menu.add(0, MENU_MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_MENU_SIZE_30, 0, "30");
                break;

        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_COLOR_BLUE:
                viewColor.setTextColor(Color.BLUE);
                break;
            case MENU_COLOR_GREEN:
                viewColor.setTextColor(Color.GREEN);
                break;
            case MENU_COLOR_RED:
                viewColor.setTextColor(Color.RED);
                break;
            case MENU_MENU_SIZE_22:
                viewSize.setTextSize(22);
                break;
            case MENU_MENU_SIZE_26:
                viewSize.setTextSize(26);
                break;
            case MENU_MENU_SIZE_30:
                viewSize.setTextSize(30);
                break;
        }
        return super.onContextItemSelected(item);
    }
}