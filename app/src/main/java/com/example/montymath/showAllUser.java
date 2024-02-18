package com.example.montymath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class showAllUser extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_user);

        recyclerView = findViewById(R.id.recUser);

        ArrayList<Fruit> fruits=new ArrayList<>();
        fruits.add(new Fruit("banana", R.drawable.banana));
        fruits.add(new Fruit("apple",R.drawable.apple));
        fruits.add(new Fruit("orange",R.drawable.orange));
        fruits.add(new Fruit("grapes",R.drawable.lemon));
        fruits.add(new Fruit("lemon",R.drawable.fru));


        MyFruitsAdapter  myFruitsAdapter = new MyFruitsAdapter(fruits);
        String size = String.valueOf(myFruitsAdapter.getItemCount());
        Toast.makeText(getApplicationContext(),size,Toast.LENGTH_SHORT).show();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myFruitsAdapter);
        recyclerView.setHasFixedSize(true);
    }
}