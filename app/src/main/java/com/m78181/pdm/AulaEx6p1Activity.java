package com.m78181.pdm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.Arrays;

public class AulaEx6p1Activity extends Activity {
    String [] values = {"Luz","Agua","Telefone","Internet","Aluguel", "Academia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainaula6p1);
    }

    ArrayAdapter<String> adapter = new ArrayAdapter(this,
            android.R.layout.simple_list_item_1, Arrays.asList(values));
    /*setListAdapter(adapter);*/
}
