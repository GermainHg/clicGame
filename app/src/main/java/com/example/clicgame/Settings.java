package com.example.clicgame;
// Application réaliséé dans le cadre de l'unité [E4fe] 4E-LE1 IHM dévelopement d'une application Android
// Auteur : LESTIENNE Raphaël / HENG Germain / GUIRAUDOU Tristan
// Support : M.BENABOU
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//menu des settings de l'application
public class Settings extends AppCompatActivity {

    //Initialisation des objets
    private Button btnMusic;
    private Button btnSkin;
    private Button btnAbout;
    private Button btnBack;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On associe la disposition du fichier xml avec l'activity
        setContentView(R.layout.activity_settings);

        //On associe l'objet bouton avec le bouton cree dans le fichier xml
        this.btnMusic = findViewById(R.id.btn_Music);
        this.btnSkin = findViewById(R.id.btn_Skin);
        this.btnAbout = findViewById(R.id.btn_About);
        this.btnBack = findViewById(R.id.btn_Back);

        //Bouton Music
        btnMusic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                startActivity(new Intent(getApplicationContext(), Music.class)); //On demarre une nouvelle activity
            }
        });

        //Bouton Skin
        btnSkin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                startActivity(new Intent(getApplicationContext(), Skin.class)); //On demarre une nouvelle activity
            }
        });

        //Bouton About
        btnAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                startActivity(new Intent(getApplicationContext(), About.class)); //On demarre une nouvelle activity
            }
        });

        //Bouton Back
        btnBack.setOnClickListener(new View.OnClickListener() { //On definit l'action a realiser apres avoir appuie le bouton
            public void onClick(View view) {
                finish(); //Met fin a l'activity
            }
        });
    }
}