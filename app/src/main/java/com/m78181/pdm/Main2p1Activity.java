package com.m78181.pdm;

import android.content.Intent;
import android.os.Bundle;


public class Main2p1Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2p1);

        Intent i = getIntent();
        String valor = i.getStringExtra("temp");

    }
}
