package com.m78181.pdm;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class Main6p2Activity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6p2);
        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getNames()
        ));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    private List<String> getNames(){
        return Arrays.asList(
                        "Dave Mustaine", "Ron McGovney", "Tom Araya", "Kerry King","Dave Lombardo",
                        "David Ellefson","James Hetfield","Lars Ulrich","Kiko Loureiro","Marty Friedman",
                        "Rob Trujillo","Joey Belladonna","Scott Ian","Dirk Verbeuren","Dan Lilker",
                        "Cliff Burton","Jason Newsted", "Jeff Hannemann");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        //do nothing
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        TextView textView = (TextView) view;
        Intent intent = new Intent(this, Main6p1Activity.class);
        intent.putExtra("nome", textView.getText());
        startActivity(intent);
    }

}
