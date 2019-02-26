package com.example.michael.myapplication;

import android.util.Log;

public class ConsTest extends ConTestFather {
    {
        Log.i("const", "block");
    }

    public ConsTest() {

        Log.i("const", "cons");

    }

    public ConsTest(int i) {
       super(1);
        Log.i("const", "consI");

    }

}
