package com.example.michael.myapplication;

import android.util.Log;

public class ConTestFather {
    public ConTestFather() {
        Log.i("const", "consf");
    }
    public ConTestFather(int i) {
        this();
        Log.i("const", "consfi");
    }
}
