package com.example.test7_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView2 extends AppCompatActivity {
    private List<Fruit> fruitList  = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        initFruit();
        ListView viewById = findViewById(R.id.listview2);
        //自定义适配器
        Adapter f  = new Adapter(ListView2.this,R.layout.fruit_item,fruitList);

        viewById.setAdapter(f);

        //点击事件  setOnItemClickListener每一项设置点击事件
        viewById.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(fruitList.get(i).getName());
                Toast.makeText(ListView2.this, fruitList.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        for (int i = 0; i < 4; i++) {
            fruitList.add(new Fruit("苹果",R.drawable.fruit_apple));
            fruitList.add(new Fruit("北瓜",R.drawable.fruit_watermelon));
        }
    }
}