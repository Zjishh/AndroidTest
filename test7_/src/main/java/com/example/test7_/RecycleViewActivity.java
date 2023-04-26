package com.example.test7_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        initFruit();

        RecyclerView RCview = findViewById(R.id.RC);

        //适配器
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(fruitList);
        ///设置RC管理器
        RCview.setLayoutManager(new LinearLayoutManager(RecycleViewActivity.this, LinearLayoutManager.VERTICAL, false));
//将适配器RCview
        RCview.setAdapter(recyclerViewAdapter);

        //

    }


    private void initFruit() {
        for (int i = 0; i < 4; i++) {
            fruitList.add(new Fruit("苹果", R.drawable.fruit_apple));
            fruitList.add(new Fruit("北瓜", R.drawable.fruit_watermelon));
        }
    }
}