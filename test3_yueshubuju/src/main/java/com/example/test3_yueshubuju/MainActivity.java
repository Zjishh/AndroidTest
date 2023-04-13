package com.example.test3_yueshubuju;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart被调用");
        setContentView(R.layout.activity_main);
        Log.i("Ac生命周期","onStart被调用");
        Button bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart被调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume被调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause被调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop被调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy被调用");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate被调用");
    }
}