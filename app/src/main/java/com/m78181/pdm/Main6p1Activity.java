package com.m78181.pdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Main6p1Activity extends Activity {

    final String [] estados = {"RS","SC","PR"};
    final String[][] cidades = {{"Santa Cruz do Sul","Porto Alegre","Caxias do Sul"},
                         {"Florianopólis","Chapecó","Blumenau"},
                         {"Curitiba","Londrina","Cascavel"}};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6p1);

        Intent intent = getIntent();
        String nome =  intent.getStringExtra("nome");

        final TextView name = (TextView) findViewById(R.id.textView1);

        name.setText(nome);

        Spinner estado = (Spinner) findViewById(R.id.estado);
        listView = findViewById(R.id.listviewCidades);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,estados);
        estado.setAdapter(adapter);
        estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ArrayAdapter<String> adapter_lst =
                        new ArrayAdapter<>(getApplicationContext(), R.layout.list_layout, R.id.textViewList, cidades[position]);
                listView.setAdapter(adapter_lst);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                listView.setAdapter(null);
            }
        });
    }
}
