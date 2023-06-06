package com.example.test10_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private DBUtil dbUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button cancel_button = findViewById(R.id.cancel_button);
        Button save_button = findViewById(R.id.save_button);
        EditText word = findViewById(R.id.word);
        EditText zhongwen = findViewById(R.id.zhongwen);

        cancel_button.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
        save_button.setOnClickListener(view -> {
            String inword = word.getText().toString();
            String inchina = zhongwen.getText().toString();
            if (inword.equals("")||inchina.equals("")){
                Toast.makeText(this, "请填写完整", Toast.LENGTH_SHORT).show();
            }else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("word",inword);
                contentValues.put("tran",inchina);
                dbUtil = new DBUtil(this, "db_dict", null, 1);
                dbUtil.getReadableDatabase().insert("tb_dict",null,contentValues);
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