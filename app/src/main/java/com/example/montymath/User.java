package com.example.montymath;

import android.net.Uri;

public class User {
    private String name;
    private int score;
    int rete;
    long id;
    Uri imageProfile;

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
    public int getRete (){return rete;}
    public Uri getImageProfileUri(){return imageProfile;}
    public void setId (long ID){id = ID;}
    public void setImageUri (Uri imageProfile){this.imageProfile = imageProfile;}

}
