package com.m78181.pdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Aula6ExActivity extends AppCompatActivity {
    private ListView meuListView;
    private Spinner meuSpinner;
    String [] values = {"Luz","Agua","Telefone","Internet","Aluguel", "Academia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainaula6);

        meuListView = findViewById(R.id.meuListView);
        meuSpinner = findViewById(R.id.meuSpinner);

        ArrayAdapter<String> adaptSpinner = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, values);
        //Adapter Spinner editado
        /*ArrayAdapter<String> adaptSpinner = new ArrayAdapter<>(this,
                R.layout.advanced_spinner_item, values);*/

        meuSpinner.setAdapter(adaptSpinner);
        meuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), values[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adaptList = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Arrays.asList(values));
        //Adapter List editado
        /*ArrayAdapter<String> adaptList = new ArrayAdapter<>(this,
                R.layout.advanced_spinner_item, values);*/
    }

    /*public void ExemploClick(View view){
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(intent);
    }*/
}
