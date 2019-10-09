package com.m78181.pdm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main8Activity extends AppCompatActivity {
    private Spinner spinnerEstado;
    private Spinner spinnerCidade;
    private final int TIRAR_FOTO = 0;
    private ListView listAlunos;
    private TextView matricula, nome, email;
    private ImageView captura;
    private Button capturar;
    private Button add;
    private ArrayList<ArrayList<Object>> memoria = new ArrayList<>();
    private String[] labels =  {"Foto", "Matricula", "Nome"};
    private

    final String [] estados = {"Selecione o estado", "Rio Grande do Sul", "Santa Catarina", "Paraná", "São Paulo"};
    final String [][] cidades = {
            {"Selecione o estado"},
            {"Porto Alegre", "Minas do Leão", "Garibaldi", "Rio Pardo", "Westfalia"},
            {"Urubici", "Florianópolis", "Urupema", "Joinville", "Blumenau"},
            {"Curitiba", "Londrina", "Ariranha do Ivai", "Guaratuba", "Imbituva"},
            {"São Paulo", "Santos", "São José do Rio Preto", "Campinas", "Ribeirão Preto"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        spinnerCidade.findViewById(R.id.revisaoCidade);
        spinnerEstado.findViewById(R.id.revisaoEstado);
        listAlunos.findViewById(R.id.listaEstudantes);
        capturar.findViewById(R.id.revisaoCapture);
        matricula.findViewById(R.id.revisaoMatricula);
        nome.findViewById(R.id.revisaoNome);
        email.findViewById(R.id.revisaoEmail);
        captura.findViewById(R.id.revisaofotoCaptura);
        add.findViewById(R.id.revisaoAdd);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,estados);
        spinnerEstado.setAdapter(adapter);
        spinnerEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View SelectedItemView, int position, long id){
                ArrayAdapter<String> adapter_lista = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, R.id.revisaoCidade, cidades[position]);
                spinnerCidade.setAdapter(adapter_lista);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView){
                //spinnerCidade.setAdapter(null);
            }
        });
        Main8Activity_adapter adaptermain8 =
                new Main8Activity_adapter(this, dados(), R.layout.activity_main8_adapter, labels, views, memoria.toArray());
        listAlunos.setAdapter(adaptermain8);
        listAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String, Object> item = list.get(position);
                //abre nova atividade e passa os dados do item selecionado
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void takePictureClick(View view){
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CAMERA}, TIRAR_FOTO);
        } else {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, TIRAR_FOTO);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case TIRAR_FOTO:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, TIRAR_FOTO);
                } else
                    Toast.makeText(this, "permissão de acesso à câmera negada", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TIRAR_FOTO && resultCode == RESULT_OK) {
            ImageView iv = findViewById(R.id.revisaofotoCaptura);
            iv.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }
    }

    public void addAluno(View view){
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(matricula);
        dados.add(nome);
        dados.add(email);
        dados.add(spinnerEstado.getSelectedItem());
        dados.add(spinnerCidade.getSelectedItem());
        dados.add(captura);

        memoria.add(dados);

        listAlunos.setAdapter(adapter);
    }



}
