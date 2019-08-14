package com.m78181.pdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    final String TAG = "App";
    private EditText tempC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //A activity está sendo criada
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //A activity está prestes a se tornar visível
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //A activity está visível
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //A activity está voltando a receber o foco depois de ficar pausada
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Outra activity está recebendo o foco, esta activity ficará pausada.
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //A activity não está mais visível mas permanece em memória
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //A activity está prestes a ser destruída (removida da memmória)
        Log.d(TAG, "onDestroy");
    }

    public void calClick(View view){
            String s = tempC.getText().toString();
            //double d = Double.parseDouble(s);
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
