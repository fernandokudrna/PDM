package com.m78181.pdm;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main8Activity extends Activity {
    private Spinner spinnerEstado;
    private Spinner spinnerCidade;
    private final int TIRAR_FOTO = 0;
    private TextView matricula, nome, email;
    private ImageView captura;
    private Main8Activity_adapter adapter;
    private ArrayList<Map<String, Object>> memoria = new ArrayList<>();
    private String[] labels =  {"Foto", "Matricula", "Nome"};
    private int[] views = {R.id.revisaoFotoLista, R.id.revisaoMatriculaLista, R.id.revisaoNomeLista};

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

        ListView listAlunos = findViewById(R.id.listaEstudantes);
        spinnerCidade = findViewById(R.id.revisaoCidade);
        spinnerEstado = findViewById(R.id.revisaoEstado);
        matricula = findViewById(R.id.revisaoMatricula);
        nome = findViewById(R.id.revisaoNome);
        email = findViewById(R.id.revisaoEmail);
        captura = findViewById(R.id.revisaofotoCaptura);

        ArrayAdapter<String> adapter_cam = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,estados);
        spinnerEstado.setAdapter(adapter_cam);
        spinnerEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View SelectedItemView, int position, long id){
                ArrayAdapter<String> adapter_lista = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, cidades[position]);
                spinnerCidade.setAdapter(adapter_lista);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView){
                spinnerCidade.setAdapter(null);
            }
        });
        adapter = new Main8Activity_adapter(this, memoria, R.layout.activity_main8_adapter, labels, views);
        listAlunos.setAdapter(adapter);
        listAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Map<String, Object> item = memoria.get(position);
                Intent intent = new Intent(getApplicationContext(), Main8p1Activity.class);
                intent.putExtra("Matricula", (String) item.get("Matricula"));
                intent.putExtra("Nome", (String) item.get("Nome"));
                intent.putExtra("Email", (String) item.get("Email"));
                intent.putExtra("Estado", (String) item.get("Estado"));
                intent.putExtra("Cidade", (String) item.get("Cidade"));
                //abre nova atividade e passa os dados do item selecionado
                startActivity(intent);
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
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TIRAR_FOTO && resultCode == RESULT_OK) {
            ImageView iv = findViewById(R.id.revisaofotoCaptura);
            iv.setImageBitmap((Bitmap) Objects.requireNonNull(data.getExtras()).get("data"));
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    public void addAluno(View view){
        final Map<String,Object> dados = new HashMap<>();
        dados.put("Matricula", matricula.getText().toString());
        dados.put("Nome", nome.getText().toString());
        dados.put("Email", email.getText().toString());
        dados.put("Estado", spinnerEstado.getSelectedItem());
        dados.put("Cidade", spinnerCidade.getSelectedItem());
        BitmapDrawable bd = (BitmapDrawable)captura.getDrawable();
        dados.put("Foto", bd.getBitmap());
        memoria.add(dados);

        adapter.notifyDataSetChanged();
    }



}
