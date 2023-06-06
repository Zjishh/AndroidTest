package com.example.test11_lianxiren;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //希望获取的通讯录的姓名
    private String colums= ContactsContract.Contacts.DISPLAY_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.bt);
        TextView viewById = findViewById(R.id.item);
        button.setOnClickListener(view -> {
            viewById.setText(getqData());
        });
    }

    //CharSequence是一个字符串的结构的接口，就是描述一个字符串
    //CharSequence:string类 stringbuffer stringbuilder 三个子类
    private CharSequence getqData() {
            //字符串构建类保存字符串 联系人姓名
        StringBuilder stringBuilder = new StringBuilder();
        //获取contentResolver
        ContentResolver contentResolver = getContentResolver();
        //2查询
        //1uri,2
        Cursor query = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    // //赵=找姓名是第几列
        int columnIndex = query.getColumnIndex(colums);
        for (query.moveToFirst(); !query.isAfterLast() ;query.moveToNext() ) {
            stringBuilder.append(query.getString(columnIndex)+"\n");
        }
        query.close();
        return stringBuilder;
    }
}