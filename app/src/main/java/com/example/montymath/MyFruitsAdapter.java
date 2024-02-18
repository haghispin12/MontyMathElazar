package com.example.montymath;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyFruitsAdapter  extends RecyclerView.Adapter< MyFruitsAdapter.MyViewHolder> {


        private ArrayList<Fruit> fruits;


        public MyFruitsAdapter(ArrayList<Fruit> fruits) {
            this.fruits = fruits;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_user, parent, false);
            return new MyViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.bind(fruits.get(position));
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return fruits.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tvFruitName ;
            ImageView ivFruitImg;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                tvFruitName = itemView.findViewById(R.id. tvFruitName);
                ivFruitImg = itemView.findViewById(R.id. ivFruitImg);
            }

            public void bind(final Fruit item)      {
                tvFruitName.setText(item.getName());
                ivFruitImg.setImageResource(item.getDrawable());
            }

        }
    }