package com.m78181.pdm;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void OC_Q1(View view){
        Intent i = new Intent(Main3Activity.this, Main3p1Activity.class);
        startActivity(i);
    }

    public void OC_Q2(View view){
        Intent i = new Intent(Main3Activity.this, Main3p2Activity.class);
        startActivity(i);
    }

    public void OC_Q3(View view){
        Intent i = new Intent(Main3Activity.this, Main3p3Activity.class);
        startActivity(i);
    }

    public void OC_Q4(View view){
        Intent i = new Intent(Main3Activity.this, Main3p4Activity.class);
        startActivity(i);
    }


}
