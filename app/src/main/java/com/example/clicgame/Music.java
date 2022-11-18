package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ListView lv;
        ArrayList<String> data;
        ArrayAdapter<String> adapter;

        lv = (ListView) findViewById(R.id.listview_1);
        data = new ArrayList<>();
        data.add("1. ");
        data.add("2. ");
        data.add("3. ");
        data.add("4. ");
        data.add("5. ");
        data.add("6. ");
        data.add("7. ");
        data.add("8. ");
        data.add("9. ");
        data.add("10. ");
        // https://developer.android.com/guide/topics/ui/declaring-layout#AdapterViews
        /* adapts an array of data of type List<T> of undetermined size. this is to further be used by a view */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  /* android standard layout for a single entry from list: just some text and just a horizontal separator */
                data /* the List<T> contents */);
        lv.setAdapter(adapter);
    }
}