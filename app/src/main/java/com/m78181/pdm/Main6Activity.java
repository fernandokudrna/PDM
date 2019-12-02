package com.m78181.pdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class Main6Activity extends Activity {
    String [] strArray = {"Dave Mustaine", "Ron McGovney", "Tom Araya", "Kerry King","Dave Lombardo",
                            "David Ellefson","James Hetfield","Lars Ulrich","Kiko Loureiro","Marty Friedman",
                            "Rob Trujillo","Joey Belladonna","Scott Ian","Dirk Verbeuren","Dan Lilker",
                            "Cliff Burton","Jason Newsted", "Jeff Hannemann"};
    private ListView listView;
    Spinner spinner;
    String [] categoria_despesa = {"Passagem", "Alimentação", "Estadia", "Outros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);

        ArrayAdapter<CharSequence> adapter_sp = ArrayAdapter.createFromResource(this, R.array.categoria_gasto,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter_sp);

        final ArrayAdapter<String> adapter_lst = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arrays.asList(categoria_despesa));
        listView.setAdapter(adapter_lst);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Mensagem(categoria_despesa[position]);
            }
        });
    }

    //Criação do Menu
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meu_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemNovo:
                Toast.makeText(this, "Novo", Toast.LENGTH_LONG).show();
                return true;
        }
        switch (item.getItemId()){
            case R.id.itemSalvar:
                Toast.makeText(this, "Salvar", Toast.LENGTH_LONG).show();
                return true;
        }
        switch (item.getItemId()){
            case R.id.itemAdicionar:
                Toast.makeText(this, "Adicionar", Toast.LENGTH_LONG).show();
                return true;
        }
        switch (item.getItemId()){
            case R.id.itemLista:
                Intent intent = new Intent(this, Main6p1Activity.class);
                startActivity(intent);
        }
        return false;
    }

    public void Mensagem(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}