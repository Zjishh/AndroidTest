package com.example.test9_addressbook;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    private List<Person> personList;

    public AddressAdapter(List<Person> personList) {
        this.personList = personList;
    }

    //界面控制器，适配器通过界面控制器来获取并控制界面
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView text;
        TextView phonenumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);
            phonenumber = itemView.findViewById(R.id.phonenumber);
        }
    }

    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person, parent, false);
        AddressAdapter.ViewHolder holder = new ViewHolder(view);
        //点击事件
        View itemView = holder.itemView;
        itemView.setOnClickListener((View) -> {
            int position = holder.getAdapterPosition();
            Toast.makeText(view.getContext(), personList.get(position).getName(), Toast.LENGTH_SHORT).show();
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.img.setImageResource(person.getImg());
        holder.text.setText(person.getName());
        holder.phonenumber.setText(person.getNumber());
    }

    @Override
    public int getItemCount() {
        System.out.println(personList.get(0).getNumber());
        return personList.size();
    }
}
