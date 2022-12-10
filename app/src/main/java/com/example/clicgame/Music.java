package com.example.clicgame;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Music extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ListView lv;
        ArrayList<String> data;
        ArrayAdapter<String> adapter;

        lv = (ListView) findViewById(R.id.listview_1);
        data = new ArrayList<>();
        data.add("doggo");
        data.add("miss");
        data.add("wut da dawg doin");

        // https://developer.android.com/guide/topics/ui/declaring-layout#AdapterViews
        /* adapts an array of data of type List<T> of undetermined size. this is to further be used by a view */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  /* android standard layout for a single entry from list: just some text and just a horizontal separator */
                data /* the List<T> contents */);
        lv.setAdapter(adapter);

        /* listen to clicks on a view whose contents depend on an adapter. that's our case */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                // Show a Toast message on item  click
                Toast.makeText(Music.this, "You clicked : " + data.get(pos), Toast.LENGTH_SHORT).show();

                switch (data.get(pos)){
                    case "doggo":
                        MediaPlayer.create(Music.this, R.raw.pop).start();
                        break;
                    case "miss":
                        MediaPlayer.create(Music.this, R.raw.miss).start();
                        break;
                    case "wut da dawg doin":
                        MediaPlayer.create(Music.this, R.raw.wtgd).start();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}