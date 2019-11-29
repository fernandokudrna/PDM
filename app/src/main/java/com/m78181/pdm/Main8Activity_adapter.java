package com.m78181.pdm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
//import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Map;


public class Main8Activity_adapter extends SimpleAdapter{
    private final Context context;
    private final int textViewResourceId;
    private List<Map<String,Object>> memoria;

    Main8Activity_adapter(Context context, List<Map<String, Object>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.memoria = data;
        this.context = context;
        this.textViewResourceId = resource;
    }

    @Override
    //@RequiresApi(api = Build.VERSION_CODES.P)
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View row = layoutInflater.inflate(this.textViewResourceId, parent, false);
        if(position != 1 && position < memoria.size()){
            TextView tvMatricula = row.findViewById(R.id.revisaoMatriculaLista);
            TextView tvNome = row.findViewById(R.id.revisaoNomeLista);
            ImageView ivFoto = row.findViewById(R.id.revisaoFotoLista);
            tvMatricula.setText((memoria.get(position).get("Matricula").toString()));
            tvNome.setText((memoria.get(position).get("Nome").toString()));
            ivFoto.setImageBitmap(((Bitmap) memoria.get(position).get("Foto")));
        }
        return row;
    }
}
