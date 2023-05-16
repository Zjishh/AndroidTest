package com.example.test8_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountinformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountinformation);
        EditText account = findViewById(R.id.account);
        EditText pass = findViewById(R.id.pass);
        Button save = findViewById(R.id.save);
        Button look = findViewById(R.id.look);

        //存储
        save.setOnClickListener(view -> {
            String inname = account.getText().toString();
            String inpassword = pass.getText().toString();
//获得对象
            SharedPreferences sharedPreferences = getSharedPreferences("accountinfo", MODE_PRIVATE);
            //获得对象.editor
            SharedPreferences.Editor edit = sharedPreferences.edit();
            //添加数据

            edit.putString("用户名", inname);
            edit.putString("密码",inpassword);

            edit.commit();
        });

        //获取
        look.setOnClickListener(view -> {
            SharedPreferences sp=getSharedPreferences("accountinfo",MODE_PRIVATE);
            String name=sp.getString("用户名","");
            String password=sp.getString("密码","");
            Toast.makeText(this, name+password, Toast.LENGTH_SHORT).show();
        });
    }
}