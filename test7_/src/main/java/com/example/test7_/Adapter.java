package com.example.test7_;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

//自定义适配器
public class Adapter extends ArrayAdapter<Fruit> {

    private int resource ;

    public Adapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }


    //重写getview   每个子项被滚动到屏幕内的时候被调用
    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //得到fruit实例
        Fruit fruit = getItem(position);
        //使用LayoutInflater 为子项加载布局
        View inflate = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        //通过ID找控件
        ImageView fruitimg = inflate.findViewById(R.id.img_fruit);
        TextView fruittext = inflate.findViewById(R.id.fruit_text);

        //将控件赋值

        fruitimg.setImageResource(fruit.getImg());
        fruittext.setText(fruit.getName());

        //将布局返回
        return inflate;
    }
}
