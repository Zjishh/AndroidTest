package com.example.test7_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView1 extends AppCompatActivity {
    private String[] a={"苹果","火龙果","芒果","草莓","西瓜",
            "哈密瓜","荔枝","葡萄","梨","苹果","火龙果",
            "芒果","草莓","西瓜", "哈密瓜","荔枝","葡萄","梨"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ListView Listview = findViewById(R.id.listview);
        //适配器
        ArrayAdapter<Object> integerArrayAdapter = new ArrayAdapter<>(ListView1.this, android.R.layout.simple_list_item_1,a);

        Listview.setAdapter(integerArrayAdapter);



    }
}