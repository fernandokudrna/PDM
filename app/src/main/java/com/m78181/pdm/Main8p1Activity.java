package com.m78181.pdm;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class Main8p1Activity extends AppCompatActivity {

    @Override
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8p1);
        Bundle extras = getIntent().getExtras();
        String matricula = (String) Objects.requireNonNull(extras).get("matricula");
        String nome = (String) Objects.requireNonNull(extras).get("nome");
        String email = (String) Objects.requireNonNull(extras).get("email");
        String estado = (String) Objects.requireNonNull(extras).get("estado");
        String cidade = (String) Objects.requireNonNull(extras).get("cidade");
        TextView mostra_rev_Matricula = findViewById(R.id.mostra_rev_Matricula);
        TextView mostra_rev_Nome = findViewById(R.id.mostra_rev_Nome);
        TextView mostra_rev_Email = findViewById(R.id.mostra_rev_Email);
        TextView mostra_rev_Estado = findViewById(R.id.mostra_rev_Estado);
        TextView mostra_rev_Cidade = findViewById(R.id.mostra_rev_Cidade);
        mostra_rev_Matricula.setText(String.format("Matrícula: %s", matricula));
        mostra_rev_Nome.setText(String.format("Nome: %s", nome));
        mostra_rev_Email.setText(String.format("Email: %s", email));
        mostra_rev_Estado.setText(String.format("Estado: %s", estado));
        mostra_rev_Cidade.setText(String.format("Cidade: %s", cidade));
    }
}
