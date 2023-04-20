package com.example.test6_toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(666);
            }
        });
        //菜单

        toolbar.inflateMenu(R.menu.menubar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                case R.id.tianjia:
                    Toast.makeText(MainActivity.this,"添加", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.gengduo:
                    Toast.makeText(MainActivity.this,"更多",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.saoyisao:
                    Toast.makeText(MainActivity.this,"扫一扫",Toast.LENGTH_SHORT).show();
                    break;
            }
return true;

            }

        });

    }
}