package com.example.montymath;

import android.graphics.drawable.Drawable;

public class Fruit{
    private String name;
    private int drawable;

    public Fruit (String Name,int D){
        name = Name;
        drawable = D;
    }



    public String getName (){return name;}
    public int getDrawable(){return drawable;}
    public void setName (String name){this.name = name;}
    public void setDrawable (int drawable){this.drawable = drawable;}
}
