package com.example.test9_addressbook;

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

public class MainActivity extends AppCompatActivity {
    private List<Person> PersonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ininPerson();
        RecyclerView PersonRC = findViewById(R.id.PersonRC);
        //适配器
        AddressAdapter recyclerViewAddressAdapter = new AddressAdapter(PersonList);
        ///设置RC管理器
        PersonRC.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        //将适配器RCview
        PersonRC.setAdapter(recyclerViewAddressAdapter);
        //列表的间隔线(Item：项，Decoration：装饰)(复制粘贴，只需要知道R.drawable.line即可)
        //LinearLayoutManager.VERTICAL：线性布局管理器垂直
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.line);
        dividerItemDecoration.setDrawable(drawable);
        PersonRC.addItemDecoration(dividerItemDecoration);

    }

    private void ininPerson() {
        for (int i = 0; i < 50; i++) {
            PersonList.add(new Person("13869979999", "警察局", R.drawable.a));
            PersonList.add(new Person("15269642333", "张家豪", R.drawable.a));
        }
    }
}