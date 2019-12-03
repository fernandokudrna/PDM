package com.m78181.pdm;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.RequiresApi;

public class Main8p1Activity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8p1);
        Bundle extras = getIntent().getExtras();

        String matricula = (String) extras.get("Matricula");
        String nome = (String) extras.get("Nome");
        String email = (String) extras.get("Email");
        String estado = (String) extras.get("Estado");
        String cidade = (String) extras.get("Cidade");

        TextView mostra_rev_Matricula = findViewById(R.id.mostra_rev_Matricula);
        TextView mostra_rev_Nome = findViewById(R.id.mostra_rev_Nome);
        TextView mostra_rev_Email = findViewById(R.id.mostra_rev_Email);
        TextView mostra_rev_Estado = findViewById(R.id.mostra_rev_Estado);
        TextView mostra_rev_Cidade = findViewById(R.id.mostra_rev_Cidade);
        mostra_rev_Matricula.setText(String.format("Matricula: %s", matricula));
        mostra_rev_Nome.setText(String.format("Nome: %s", nome));
        mostra_rev_Email.setText(String.format("Email: %s", email));
        mostra_rev_Estado.setText(String.format("Estado: %s", estado));
        mostra_rev_Cidade.setText(String.format("Cidade: %s", cidade));
    }
}
