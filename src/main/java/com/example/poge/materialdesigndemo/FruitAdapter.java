package com.example.poge.materialdesigndemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Anpo on 2017/3/6.
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder> {


    private ArrayList<Fruit> list;
    private Context mcontext;

    public FruitAdapter(ArrayList<Fruit> list) {
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView  imgFruit;
        TextView textFruit;
        View itemView;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            imgFruit= (ImageView) itemView.findViewById(R.id.fruit_image);
            textFruit= (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }

    @Override
    public FruitAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mcontext==null)
            mcontext=parent.getContext();
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_friut, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = list.get(position);
                Intent intent=new Intent(mcontext,FriutActivity.class);
                intent.putExtra(FriutActivity.IMG,fruit.getResId());
                mcontext.startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.MyViewHolder holder, int position) {
        Fruit fruit = list.get(position);
        holder.textFruit.setText(fruit.getName());
        Glide.with(mcontext).load(fruit.getResId()).into(holder.imgFruit);


    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
}
