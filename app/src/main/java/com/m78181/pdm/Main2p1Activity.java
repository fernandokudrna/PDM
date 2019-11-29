package com.m78181.pdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Main2p1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2p1);

        Intent i = getIntent();
        String valor = i.getStringExtra("temp");
        TextView t = findViewById(R.id.resultTemp);
        t.setText(t.getText() + valor + "Fº");
    }
}
