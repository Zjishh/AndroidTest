package com.example.test5_fragment;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
import android.app.Fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById_img1 = findViewById(R.id.img1);
        View viewById_img2 = findViewById(R.id.img2);
        View viewById_img3 = findViewById(R.id.img3);
        View viewById_img4 = findViewById(R.id.img4);

        View.OnClickListener onClickObj = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //fragment管理器：用来管理activity中的fragment
                FragmentManager fm = getFragmentManager();
                //fragment事务
                FragmentTransaction ft = fm.beginTransaction();

                //初始化
                Fragment fragment_out = new Fragment();
                switch (view.getId()){
                    case R.id.img1:
                        fragment_out = new BlankFragmentone();break;
                    case R.id.img2:
                        fragment_out = new BlankFragment();break;
                    case R.id.img3:
                        fragment_out = new BlankFragment2();break;
                    case R.id.img4:
                        fragment_out = new BlankFragment3();break;
                    default:break;
                }
                //替换fragment
                ft.replace(R.id.fragment,fragment_out);
                //提交事务
                ft.commit();
            }
        };

        viewById_img1.setOnClickListener(onClickObj);
        viewById_img2.setOnClickListener(onClickObj);
        viewById_img3.setOnClickListener(onClickObj);
        viewById_img4.setOnClickListener(onClickObj);
    }
}