package com.example.montymath;

import java.util.Random;

public class Exercise {
    protected  int num1;
    protected  int num2;
    protected  int answer;

    public Exercise (int Num1,int Num2,int Answer){
        num1 = Num1;
        num2 = Num2;
    }

    public  Exercise(){

    }

    public void setNum1(int New){
        num1 = New;
    }
    public void setNum2(int New){
        num2 = New;
    }
    public void setAnswor (int x){
        answer = x;
    }
    public int multiplication (int n1, int n2){
        return n1*n2;
    }


    public boolean chakeAnswor(String a){
        int x = Integer.valueOf(a);
        int y = multiplication(num1,num2);
        answer = x;
        return y == x;
    }
    public int get_ran_ap20_num1 (){
        Random r = new Random();
        this.num1 = r.nextInt(20)+1;
        return num1;
    }
    public int get_ran_ap20_num2 (){
        Random r = new Random();
        this.num2 = r.nextInt(20)+1;
        return num2;
    }
    public int get_ran_ap10_num1 (){
        Random r = new Random();
        this.num1 = r.nextInt(10)+1;
        return num1;
    }
    public int get_ran_ap10_num2 (){
        Random r = new Random();
        this.num2 = r.nextInt(10)+1;
        return num2;
    }

}













