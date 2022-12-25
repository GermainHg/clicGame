package com.example.clicgame;
// Application réaliséé dans le cadre de l'unité [E4fe] 4E-LE1 IHM dévelopement d'une application Android
// Auteur : LESTIENNE Raphaël / HENG Germain / GUIRAUDOU Tristan
// Support : M.BENABOU
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

    //Initialisation du RecyclerView qui das el code suivant n'est pas utilisé
    private RecyclerView recyclerView;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On associe la disposition du fichier xml avec l'activity
        setContentView(R.layout.activity_music);

        //Creation d'une ListView, d'une Arraylist et d'une Arrayadapter
        ListView lv;
        ArrayList<String> data;
        ArrayAdapter<String> adapter;

        //On associe l'objet ListView avec la ListView cree dans le fichier xml
        lv = (ListView) findViewById(R.id.listview_1);

        //On cree une ArrayList qu'on remplit des sons que nous utilisons
        data = new ArrayList<>();
        data.add("doggo");
        data.add("miss");
        data.add("wut da dawg doin");

        // https://developer.android.com/guide/topics/ui/declaring-layout#AdapterViews
        // aide des application exemple de M.BENABOU
        /* adapts an array of data of type List<T> of undetermined size. this is to further be used by a view */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  /* android standard layout for a single entry from list: just some text and just a horizontal separator */
                data);

        //On ajoute l'adapter a notre ListView
        lv.setAdapter(adapter);

        //Listen to clicks on a view whose contents depend on an adapter
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) { //On definit l'action a realiser apres avoir appuie un item

                // On affiche un toast quand on clique sur un item de notre listView
                Toast.makeText(Music.this, "You clicked : " + data.get(pos), Toast.LENGTH_SHORT).show();

                //Action a realiser selon l'item cliqué
                switch (data.get(pos)){
                    case "doggo":
                        MediaPlayer.create(Music.this, R.raw.pop).start(); //Joue un fichier audio
                        break;
                    case "miss":
                        MediaPlayer.create(Music.this, R.raw.miss).start(); //Joue un fichier audio
                        break;
                    case "wut da dawg doin":
                        MediaPlayer.create(Music.this, R.raw.wtgd).start(); //Joue un fichier audio
                        break;
                    default:
                        break;
                }
            }
        });
    }
}