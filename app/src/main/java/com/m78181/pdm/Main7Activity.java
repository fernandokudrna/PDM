package com.m78181.pdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main7Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }

    public void aula7_1Click(View view) {
        Intent intent = new Intent(getApplicationContext(),Main7p1Activity.class);
        startActivity(intent);
    }

    public void aula7_2Click(View view) {
        Intent intent = new Intent(getApplicationContext(),Main7p2Activity.class);
        startActivity(intent);
    }
}
