package com.example.test4_329;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button com = findViewById(R.id.bt_commit);
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = ((EditText) (findViewById(R.id.et1))).getText().toString();
                String s2 = ((EditText) (findViewById(R.id.et2))).getText().toString();
                String s3 = ((EditText) (findViewById(R.id.et3))).getText().toString();
                String s4 = ((EditText) (findViewById(R.id.et4))).getText().toString();
                String s5 = ((EditText) (findViewById(R.id.et5))).getText().toString();

                //判断是否为空
                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")){
                    Toast.makeText(MainActivity.this, "请填写完整", Toast.LENGTH_SHORT).show();
                }
                else {
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("t1",s1);
                    bundle.putCharSequence("t2",s2);
                    bundle.putCharSequence("t3",s3);
                    bundle.putCharSequence("t4",s4);
                    bundle.putCharSequence("t5",s5);
                    System.out.println(bundle);

                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtras(bundle);
                    startActivity(intent);


                }
            }
        });
    }
}