package com.example.test8_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        EditText edit = findViewById(R.id.edit);
        ImageView save = findViewById(R.id.save);
        ImageView cancel = findViewById(R.id.cancel);


        cancel.setOnClickListener(view -> {
            finish();
        });

        save.setOnClickListener(view -> {
            //获取输入的备忘信息
            String s = edit.getText().toString();
            //保存  第二个参数 设置访问权限 只有当前应用能够访问↓
            FileOutputStream out = null;
            try {
                out = openFileOutput("out", MODE_APPEND);
                out.write(s.getBytes());
                out.flush();//清除缓存
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                //静态关闭
                if (out != null) {


                    try {
                        out.close();
                        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });

        //读取文件
        FileInputStream in = null;
        byte[] buffer = null;
        try {
            in = openFileInput("out");
            //实例化字节数组
            buffer = new byte[in.available()];
            in.read(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            //静态关闭
            if (in != null) {
                try {
                    in.close();
                    //字节数组转成字符串
                    String s = new String(buffer);
                    System.out.println(s);
                    edit.setText(s);
                    Toast.makeText(this, "读取", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }




    }
}