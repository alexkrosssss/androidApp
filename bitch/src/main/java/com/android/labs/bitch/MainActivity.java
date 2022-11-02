package com.android.labs.bitch;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//second approach use listener
public class MainActivity extends AppCompatActivity{// implements View.OnClickListener{

    TextView textViewOut;
    Button btnOk;
    Button btnCancel;

    private static final String TAG = "testLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        btnCancel = findViewById(R.id.btnCancel);
        btnOk = findViewById(R.id.btnOk);
        textViewOut = findViewById(R.id.textViewOut);

//first approach use listener
        View.OnClickListener onBtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "define button that invoked parser");
                switch (view.getId()) {
                    case R.id.btnCancel:
                        Log.d(TAG, "button OK");
                        textViewOut.setText(R.string.textCancel);
                        Toast.makeText(getApplicationContext(),R.string.textCancel,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btnOk:
                        Log.d(TAG, "button Cancel");
                        btnOk.setBackground(getResources().getDrawable(R.color.colorPink));
                        textViewOut.setText(R.string.textOk);
                        Toast.makeText(getApplicationContext(),R.string.textOk,Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        };

        btnOk.setOnClickListener(onBtn);
        btnCancel.setOnClickListener(onBtn);
        //clear top bar
//        Window w = getWindow();
//        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
//        menu.add(0,1,3,"menu3");
//        menu.add(0,2,2,"menu2");
//        menu.add(0,3,1,"menu1");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    //third approach use listener
//    public void clickBtnOk(View view) {
//        textViewOut.setText("Button OK presses");
//    }
//    public void clickBtnCancel(View view) {
//        textViewOut.setText("Button Cancel presses");
//    }


//second approach use listener
//        btnOk.setOnClickListener(this::onClick);
//        btnCancel.setOnClickListener(this::onClick);
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btnCancel:
//                textViewOut.setText("Button Cancel presses");
//                break;
//            case R.id.btnOk:
//                textViewOut.setText("Button OK presses");
//                break;
//
//        }
//    }
}