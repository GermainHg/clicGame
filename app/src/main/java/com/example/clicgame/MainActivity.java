package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Initialisation des boutons
    private Button btnPlay;
    private Button btnSettings;
    private Button btnRecords;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On associe la disposition du fichier xml avec l'activity
        setContentView(R.layout.activity_main);

        //On associe l'objet bouton avec le bouton cree dans le fichier xml
        this.btnPlay = (Button) findViewById(R.id.btn_Play);
        this.btnSettings = (Button) findViewById(R.id.btn_Settings);
        this.btnRecords= (Button) findViewById(R.id.btn_Records);

        //Bouton Play
        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                startActivity(new Intent(getApplicationContext(), Username.class)); //On cree et passe sur une nouvelle activity
            }
        });

        //Bouton Records
        btnRecords.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                startActivity(new Intent(getApplicationContext(), Records.class)); //On cree et passe sur une nouvelle activity
            }
        });

        //Bouton Settings
        btnSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                startActivity(new Intent(getApplicationContext(), Settings.class)); //On cree et passe sur une nouvelle activity
            }
        });
    }
}