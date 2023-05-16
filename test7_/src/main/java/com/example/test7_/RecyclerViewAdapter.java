package com.example.test7_;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//ViewHolder界面控制器
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    //加载数据列表
    private List<Fruit> myFruitList;
    //有参构造
    public RecyclerViewAdapter(List<Fruit> myFruitList) {
        this.myFruitList = myFruitList;
    }

    //界面控制器，适配器通过界面控制器来获取并控制界面
    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_fruit;
        TextView text_fruit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_fruit = itemView.findViewById(R.id.img_fruit);
            text_fruit = itemView.findViewById(R.id.fruit_text);
        }
    }
    //创建界面控制器
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        RecyclerViewAdapter.ViewHolder holder = new RecyclerViewAdapter.ViewHolder(view);
        //点击事件
        View itemView = holder.itemView;
        itemView.setOnClickListener((View)-> {
            int position = holder.getAdapterPosition();

            Toast.makeText(view.getContext(), myFruitList.get(position).getName(), Toast.LENGTH_SHORT).show();

        });
        return holder;
    }
        //数据绑定到界面上
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Fruit fruit = myFruitList.get(position);
        holder.img_fruit.setImageResource(fruit.getImg());
        holder.text_fruit.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return myFruitList.size();
    }


}
