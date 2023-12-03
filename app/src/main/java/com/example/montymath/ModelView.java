package com.example.montymath;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ModelView extends ViewModel {
    public MutableLiveData <Integer> vNum1;
    public MutableLiveData <Integer> vNum2;
    public MutableLiveData <Integer> vScore;
    Exercise exercise;
    user user;

    public ModelView(){
        vNum1  = new MutableLiveData<>();
        vNum2 = new MutableLiveData<>();
        vScore = new MutableLiveData<>();
        exercise = new Exercise();
        user = new user();
    }

    public void cefel_20 (){
        vNum1.setValue(exercise.get_ran_ap20_num1());
        vNum2.setValue(exercise.get_ran_ap20_num2());
    }

    public void cefel_board  (){
        vNum1.setValue(exercise.get_ran_ap10_num1());
        vNum2.setValue(exercise.get_ran_ap10_num2());
    }
    public Boolean chak (String x,int state){
       Boolean b =  exercise.chakeAnswor(x);
       if(b){
           if(state == 1){
               user.setScore(user.getScore()+1000000000);
           } else if (state == 2){
               user.setScore(user.getScore()+1000000000);
           }else if (state == 3){
               user.setScore(user.getScore()+1000000000);
           }
           vScore.setValue(user.getScore());
       }
       return b;
    }
    public void appDateName (String name){
        user.setName(name);
    }

}
