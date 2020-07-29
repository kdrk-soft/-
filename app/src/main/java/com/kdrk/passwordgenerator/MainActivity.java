package com.kdrk.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvNumber;
    private EditText etPassword;
    private ArrayList<String> arrayPassword = new ArrayList<>();
    private Button btList;
    private Boolean aBoolean = false;
    private Animation anim;
    final static String textViewTexKey = "TEXTVIEW_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //сохранение textview при смене ориентации
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(textViewTexKey, tvNumber.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String textViewText = savedInstanceState.getString(textViewTexKey);
        tvNumber.setText(textViewText);
    }

    public void init() {
        tvNumber = findViewById(R.id.textView);
        etPassword = findViewById(R.id.editText);
        btList = findViewById(R.id.button2);
        anim = AnimationUtils.loadAnimation(this, R.anim.my);
    }

    public void passwordGener() {
        int n = 8;
        String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for (int m = 10; m > 0; m--) {
            StringBuilder pass = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int k = (int) (Math.random() * 62);
                pass.append(set.charAt(k));
            }
            arrayPassword.add(pass.toString());

        }
        for (int a = 0; a < arrayPassword.size() - 1; a++) {
            etPassword.append(arrayPassword.get(a) + "\n");
            tvNumber.append((a + 1) + ".     " + "\n");
        }
        etPassword.append(arrayPassword.get(9));
        tvNumber.append((10) + ".     ");
    }

    public void onClickGenerate(View view) {
        arrayPassword.clear();
        etPassword.setText("");
        tvNumber.setText("");
        passwordGener();

        btList.setText(R.string.hide);
        btList.setBackgroundResource(R.color.bt);
        tvNumber.setVisibility(View.VISIBLE);
        etPassword.setVisibility(View.VISIBLE);
        aBoolean=false;
    }

    public void onClickList(View view) {

        if (aBoolean == false) {
            btList.setText(R.string.show);
            tvNumber.startAnimation(anim);
            etPassword.startAnimation(anim);

            tvNumber.setVisibility(View.INVISIBLE);
            etPassword.setVisibility(View.INVISIBLE);
            aBoolean=true;
        }
        else {
            btList.setText(R.string.hide);

            tvNumber.setVisibility(View.VISIBLE);
            etPassword.setVisibility(View.VISIBLE);
            aBoolean=false;
        }
    }
}