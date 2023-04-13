package com.example.test4_329;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        //1.获取传值
        Intent  intent = getIntent();
        Bundle extras = intent.getExtras();
        String a1 = extras.getString("t1");
        String a2 = extras.getString("t2");
        String a3 = extras.getString("t3");
        String a4 = extras.getString("t4");
        String a5 = extras.getString("t5");

        //2.显示
        TextView t1 = findViewById(R.id.tw1);
        TextView t2 = findViewById(R.id.tw2);
        TextView t3 = findViewById(R.id.tw3);

        t1.setText(a1+"省"+a2+"市"+a3+"");
        t2.setText(a4);
        t3.setText(a5);
    }
}