package com.example.test10_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
     private DBUtil dbUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = findViewById(R.id.add);
        Button translate = findViewById(R.id.translate);
        EditText in = findViewById(R.id.in);
        ListView list_item = findViewById(R.id.list_item);

        add.setOnClickListener(view -> startActivity(new Intent(this, AddActivity.class)));
        translate.setOnClickListener(view -> {
            //获取信息
            String s = in.getText().toString();
            String[] ins = {s};
            //查询
            //第二个参数是数据库的名字
            dbUtil = new DBUtil(MainActivity.this, "db_dict", null, 1);
            //表名 ，列（不指名查询所有列），where,?占位符的值-------
            Cursor cursor = dbUtil.getReadableDatabase().query("tb_dict", null, "word=?", ins, null, null, null);
            List<String> list = new ArrayList<>();
            while (cursor.moveToNext()) {
                //获取第三列
                list.add(cursor.getString(2));
            }
            if (list.size() == 0) {
                Toast.makeText(this, "没有此单词", Toast.LENGTH_SHORT).show();
            } else {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, list);
                list_item.setAdapter(arrayAdapter);
            }


        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbUtil != null) {
            dbUtil.close();
        }
    }
}