package com.example.test8_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.bt);
        Button bt2 = findViewById(R.id.bt2);


        bt.setOnClickListener((view -> {
            Intent intent = new Intent(MainActivity.this,InternalActivity.class);
            startActivity(intent);
        }));

        bt2.setOnClickListener((view -> {
            Intent intent = new Intent(MainActivity.this,AccountinformationActivity.class);
            startActivity(intent);
        }));
    }
}