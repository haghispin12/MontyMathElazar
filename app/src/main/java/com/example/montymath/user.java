package com.example.montymath;

public class user {
    private String name;
    private int score;

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public user(){
        name ="";
        score = 0;
    }
    public int getScore (){
        return score;
    }
}
