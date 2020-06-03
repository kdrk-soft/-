package com.kdrk.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView number;
    private EditText password;
    private ArrayList<String> arrayPassword = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init() {
        number = findViewById(R.id.textView);
        password = findViewById(R.id.editText);
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
        for (int a = 0; a < arrayPassword.size()-1; a++) {
            password.append(arrayPassword.get(a) + "\n");
            number.append((a+1)+".     " +"\n");
        }
        password.append(arrayPassword.get(9));
        number.append((10)+".     ");
    }

    public void onClickGenerate(View view) {
        arrayPassword.clear();
        password.setText("");
        number.setText("");
        passwordGener();
    }
}