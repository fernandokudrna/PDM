package com.m78181.pdm;


import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Main1Activity extends Activity {
    final String TAG = "App";
    private EditText tempC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
}
