package com.m78181.pdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Main6Activity extends AppCompatActivity {
    String [] strArray = {"Dave Mustaine", "Ron McGovney", "Tom Araya", "Kerry King","Dave Lombardo",
                            "David Ellefson","James Hetfield","Lars Ulrich","Kiko Loureiro","Marty Friedman",
                            "Rob Trujillo","Joey Belladonna","Scott Ian","Dirk Verbeuren","Dan Lilker",
                            "Cliff Burton","Jason Newsted", "Jeff Hannemann"};
    private TextView txt;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

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
            case R.id.item1:
                Toast.makeText(this, "Item", Toast.LENGTH_LONG).show();
                //Abre o listactivity no item do menu
                //txt = findViewById(R.id.txt1);
                listView = findViewById(R.id.listView);

                List<String> arraylist = Arrays.asList(strArray);
                ArrayAdapter<String> adapter_ls = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraylist);
                listView.setAdapter(adapter_ls);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Mensagem(strArray[position], view);
                    }
                });
                return true;
        }
        switch (item.getItemId()){
            case R.id.item2:
                Toast.makeText(this, "Item 1", Toast.LENGTH_LONG).show();
                return true;
        }
        switch (item.getItemId()){
            case R.id.item3:
                Toast.makeText(this, "Item 2", Toast.LENGTH_LONG).show();
                return true;
        }
        switch (item.getItemId()){
            case R.id.item4:
                Toast.makeText(this, "Item 3", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

    public void Mensagem(String msg, View view) {
        Intent intent = new Intent(this, Main6p1Activity.class);
        intent.putExtra("nome", msg);
        startActivity(intent);
    }

}