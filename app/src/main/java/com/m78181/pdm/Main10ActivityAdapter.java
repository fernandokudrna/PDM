package com.m78181.pdm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
//import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Map;

public class Main10ActivityAdapter extends SimpleAdapter {

    private Context context;
    private int textViewResourceId;
    private List<Map<String,Object>> data;

    public Main10ActivityAdapter(Context context, List<Map<String, Object>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.data = data;
        this.context = context;
        this.textViewResourceId = resource;
    }

    @Override
    //@RequiresApi(api = Build.VERSION_CODES.Q)
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        @SuppressLint("ViewHolder") View row = layoutInflater.inflate (this.textViewResourceId, parent, false);

        TextView temp = row.findViewById(R.id.aula10_temperatura);
        TextView umi = row.findViewById(R.id.aula10_umidade);
        TextView orv = row.findViewById(R.id.aula10_orvalho);
        TextView pre = row.findViewById(R.id.aula10_pressao);
        TextView vel = row.findViewById(R.id.aula10_velocidade);
        TextView dir = row.findViewById(R.id.aula10_direcao);
        TextView date = row.findViewById(R.id.aula10_datahora);

        temp.setText(String.format("%s%s", temp.getText(), data.get(position).get("temp")));
        umi.setText(String.format("%s%s", umi.getText(), data.get(position).get("hum")));
        orv.setText(String.format("%s%s", orv.getText(), data.get(position).get("orv")));
        pre.setText(String.format("%s%s", pre.getText(), data.get(position).get("pre")));
        vel.setText(String.format("%s%s", vel.getText(), data.get(position).get("vel")));
        dir.setText(String.format("%s%s", dir.getText(), data.get(position).get("dir")));
        date.setText(String.format("%s%s", date.getText(), data.get(position).get("data")));

        return row;
    }
}
