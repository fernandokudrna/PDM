package com.m78181.pdm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main8Activity_adapter extends SimpleAdapter{

    private int textViewResourceId;
    private Object[] objects;

    public Main8ActivityAdapter(Context context, int textViewResourceId, Object[] objects){
        super(context, textViewResourceId, objects);
        this.textViewResourceId = textViewResourceId;
        this.objects = objects;
    }
    private View getCustomView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = ((Activity)super.getContext()).getLayoutInflater();
        View row = layoutInflater.inflate (this.textViewResourceId, parent, false);

        TextView tMat = (TextView) row.findViewById(R.id.revisaoMatriculaLista);
        TextView tNome = (TextView) row.findViewById(R.id.revisaoNomeLista);
        TextView tFoto = (TextView) row.findViewById(R.id.revisaoFotoLista);


        return row;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= super.getView(position, convertView, parent);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        HashMap<String, Object> item = list.get(position);

    }
}
