package com.example.test7_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
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

        //列表的间隔线(Item：项，Decoration：装饰)(复制粘贴，只需要知道R.drawable.line即可)
        //LinearLayoutManager.VERTICAL：线性布局管理器垂直
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(RecycleViewActivity.this, LinearLayoutManager.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(RecycleViewActivity.this, R.drawable.line);
        dividerItemDecoration.setDrawable(drawable);
        RCview.addItemDecoration(dividerItemDecoration);

    }


    private void initFruit() {
        for (int i = 0; i < 4; i++) {
            fruitList.add(new Fruit("苹果", R.drawable.fruit_apple));
            fruitList.add(new Fruit("北瓜", R.drawable.fruit_watermelon));
        }
    }
}