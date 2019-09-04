package com.m78181.pdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    protected void onClickq1(View view){
        Intent i = new Intent(this, Main3p1Activity.class);
        startActivity(i);
    }

    protected void onClickq2(){
        Intent i = new Intent(this, Main3p2Activity.class);
        startActivity(i);
    }

    protected void onClickq3(){
        Intent i = new Intent(this, Main3p3Activity.class);
        startActivity(i);
    }

    protected void onClickq4(){
        Intent i = new Intent(this, Main3p4Activity.class);
        startActivity(i);
    }


}
