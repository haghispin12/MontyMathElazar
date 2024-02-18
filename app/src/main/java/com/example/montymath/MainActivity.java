package com.example.montymath;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button EtgarButtom;
    Button cefel_ad_20;
    Button cefel_board;
    EditText num_A;
    EditText num_B;
    EditText answer;
    Button chak;
    Button show;
    Button showAllUser;
    Button SaveButton;
    TextView Multiplication;
    ModelView vm;
    TextView score;
    Button rate;
    int state =1;


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int num = result.getData().getIntExtra("rate",-1);
                    vm.setRate(num);
                    rate.setText(num+"");
                }
            }
    );

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

        vm.vName.setValue(name);

        SaveButton = findViewById(R.id.SaveButton);
        EtgarButtom = findViewById(R.id.EtgarButtom);
        cefel_ad_20 = findViewById(R.id.cefel_ad_20);
        cefel_board = findViewById(R.id.cefel_board);
        num_A = findViewById(R.id.num_A);
        num_B = findViewById(R.id.num_B);
        answer = findViewById(R.id.answer);
        chak = findViewById(R.id.chak);
        show = findViewById(R.id.show_all);

        Multiplication = findViewById(R.id.multiplication);
        score = findViewById(R.id.score);
        rate = findViewById(R.id.rate);

        vm.appDateName(name);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.frameLayout, new ShowAllUserFragment());
//                trans.commit();
                Intent intent1 = new Intent(MainActivity.this, showAllUser.class);
                startActivity(intent1);

            }
        });
        EtgarButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = 2;
            }
        });
        cefel_ad_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.cefel_20(); state = 1;
            }
        });
        cefel_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = 3;
                vm.cefel_board();
            }
        });
        chak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vm.chak(answer.getText().toString(),state)){
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
                addNote("save");
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

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), com.example.montymath.rate.class);
                activityResultLauncher.launch(intent1);
            }
        });

    }
}