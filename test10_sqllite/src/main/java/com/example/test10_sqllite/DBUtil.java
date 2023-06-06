package com.example.test10_sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBUtil extends SQLiteOpenHelper {
    private Context mcontext;
    //创建数据库表
    final String  CREATE_TABLE_SQL = "create table tb_dict (id integer primary key autoincrement,word text,tran text)";

    public DBUtil(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);
        Toast.makeText(mcontext, "创建表成功", Toast.LENGTH_SHORT).show();
    }

    //处理版本情况
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Toast.makeText(mcontext, "版本更新----"+i+"---->"+i1, Toast.LENGTH_SHORT).show();
    }
}
