package com.example.montymath;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class fragment extends Fragment {
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle save){
        return inflater.inflate(R.layout.fragment_showusers,container,false);
    }
}
