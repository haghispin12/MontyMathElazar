package com.example.montymath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button EtgarButtom;
    Button cefel_ad_20;
    Button cefel_board;
    EditText num_A;
    EditText num_B;
    EditText answer;
    Button chak;
    Button show;
    Button SaveButton;
    TextView Multiplication;
    ModelView vm;
    TextView score;

    public void addNote (String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        addNote(name);

        vm = new ViewModelProvider(this).get(ModelView.class);

        SaveButton = findViewById(R.id.SaveButton);
        EtgarButtom = findViewById(R.id.EtgarButtom);
        cefel_ad_20 = findViewById(R.id.cefel_ad_20);
        cefel_board = findViewById(R.id.cefel_board);
        num_A = findViewById(R.id.num_A);
        num_B = findViewById(R.id.num_B);
        answer = findViewById(R.id.answer);
        chak = findViewById(R.id.chak);
        show = findViewById(R.id.show);
        Multiplication = findViewById(R.id.multiplication);
        score = findViewById(R.id.score);

        vm.appDateName(name);


        EtgarButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cefel_ad_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.cefel_20();
            }
        });
        cefel_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        chak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vm.chak(answer.getText().toString())){
                    addNote("Correct");
                }else {
                    addNote("Incorrect");
                }
                answer.setText("");

            }
        });
        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        vm.vNum1.observe(this,new Observer<Integer>() {
            @Override
            public void onChanged(Integer num1) {
                num_A.setText(num1+"");
            }
        });
        vm.vNum2.observe(this,new Observer<Integer>() {
            @Override
            public void onChanged(Integer num1) {
                num_B.setText(num1+"");
            }
        });
        vm.vScore.observe(this,new Observer<Integer>() {
            @Override
            public void onChanged(Integer num1) {
                score.setText(num1+"");
            }
        });


    }
}