package com.m78181.pdm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import java.util.List;
import java.util.Map;

public class Main7p1ActivityAdapter extends SimpleAdapter {

    protected Main7p1ActivityAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        if(position < 6)
            view.setBackgroundColor(0xFFFFFF00);
        else if(position > 15)
            view.setBackgroundColor(0xFFEE0000);
        else if(position % 2 != 0)
            view.setBackgroundColor(0x00000000);
        else
            view.setBackgroundColor(0xCCCCCCCC);

        return view;
    }
}
