package com.example.montymath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class logIn extends AppCompatActivity {

    EditText name;
    Button next;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        name = findViewById(R.id.name_input);
        next = findViewById(R.id.Next);

        SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        String s1 = sh.getString("name","");

        name.setText(s1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("name", name.getText().toString());
                myEdit.apply();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("name",name.getText().toString());
                myEdit.putString("name",name.getText().toString());
                myEdit.apply();
                startActivity(intent);
                finish();
            }
        });
    }
}