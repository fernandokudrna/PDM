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

    String [] estados = {"Escolha o estado","RS","SC","PR"};
    String [] estado_RS = {"Santa Cruz do Sul","Porto Alegre","Caxias do Sul"};
    String [] estado_SC = {"Florianopólis","Chapecó","Blumenau"};
    String [] estado_PR = {"Curitiba","Londrina","Cascavel"};
    String [] estado0 = {};
    ArrayAdapter<String> adaptador;

    ListView opcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6p1);

        Intent intent = getIntent();
        String nome =  intent.getStringExtra("nome");

        TextView name = (TextView) findViewById(R.id.textView1);

        name.setText(nome);

        Spinner estado = (Spinner) findViewById(R.id.estado);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,estados);

        estado.setAdapter(adapter);

        estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selecionado = estados[position];
                if(selecionado.equals("Escolha o estado")){
                    opcoes = (ListView) findViewById(R.id.listView);
                    adaptador = new ArrayAdapter<String>(Main6p1Activity.this,android.R.layout.simple_list_item_1,estado0);
                    opcoes.setAdapter(adaptador);
                }
                if(selecionado.equals("RS")){
                    opcoes = (ListView) findViewById(R.id.listView);
                    adaptador = new ArrayAdapter<String>(Main6p1Activity.this,android.R.layout.simple_list_item_1,estado_RS);
                    opcoes.setAdapter(adaptador);
                }
                if(selecionado.equals("SC")){
                    opcoes = (ListView) findViewById(R.id.listView);
                    adaptador = new ArrayAdapter<String>(Main6p1Activity.this,android.R.layout.simple_list_item_1,estado_SC);
                    opcoes.setAdapter(adaptador);
                }
                if(selecionado.equals("PR")){
                    opcoes = (ListView) findViewById(R.id.listView);
                    adaptador = new ArrayAdapter<String>(Main6p1Activity.this,android.R.layout.simple_list_item_1,estado_PR);
                    opcoes.setAdapter(adaptador);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
