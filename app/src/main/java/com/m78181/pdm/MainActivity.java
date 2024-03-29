package com.m78181.pdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //essa activity está associada a activity_main
    }

    public void aula1Click(View view){
        Intent intent = new Intent(MainActivity.this, Main1Activity.class);
        startActivity(intent);
    }

    public void aula2Click(View view){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void aula3Click(View view){
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(intent);
    }

    public void aula4Click(View view){
        Intent intent = new Intent(MainActivity.this, Main4Activity.class);
        startActivity(intent);
    }

    /*public void aula5Click(View view){
        Intent intent = new Intent(MainActivity.this, Main5Activity.class);
        startActivity(intent);
    }*/

    public void aula6Click(View view){
        Intent intent = new Intent(MainActivity.this, Main6Activity.class);
        startActivity(intent);
    }

    public void aula7Click(View view){
        Intent intent = new Intent(MainActivity.this, Main7Activity.class);
        startActivity(intent);
    }

    public void aulaRevisaoClick(View view){
        Intent intent = new Intent (MainActivity.this, Main8Activity.class);
        startActivity(intent);
    }

    public void aula10Click(View view){
        Intent intent = new Intent (MainActivity.this, Main10Activity.class);
        startActivity(intent);
    }

}
