package com.example.montymath;

public class User {
    private String name;
    private int score;
    int rete;

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setRete (int rete){this.rete = rete;}
    public User(){
        name ="";
        score = 0;
        rete =0;
    }
    public int getScore (){
        return score;
    }
    public String getName(){return name;}
}
