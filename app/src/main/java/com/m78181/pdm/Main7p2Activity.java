package com.m78181.pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Spinner;

public class Main7p2Activity extends AppCompatActivity {
    private String[] Nomes = {"Escolha uma cor","Slick Black Cadillac", "Under Grey Skies",
                              "Grey Chapter", "Grey Goose", "Whitesnake",
                              "Red Fang","Green River","Blue Orchid",
                              "Pink Floyd", "Cyanide", "Yellow Submarine"};
    private int[] cores = {Color.TRANSPARENT,Color.BLACK,Color.DKGRAY,
                           Color.GRAY,Color.LTGRAY,Color.WHITE,
                           Color.RED, Color.GREEN, Color.BLUE,
                           Color.MAGENTA, Color.CYAN, Color.YELLOW};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7p2);

        Spinner spinner = (Spinner) findViewById(R.id.colorSpinner);
        spinner.setAdapter(new Main7p2ActivityAdapter(this, R.layout.activity_main7p2_adapter, Nomes, cores));
    }
}
