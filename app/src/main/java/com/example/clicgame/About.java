package com.example.clicgame;
// Application réaliséé dans le cadre de l'unité [E4fe] 4E-LE1 IHM dévelopement d'une application Android
// Auteur : LESTIENNE Raphaël / HENG Germain / GUIRAUDOU Tristan
// Support : M.BENABOU
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Cette activity sert à "signer notre application"
public class About extends AppCompatActivity {

    //Initialisation d'un bouton
    private Button btnBack;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On associe la disposition du fichier xml avec l'activity
        setContentView(R.layout.activity_about);

        //On associe l'objet bouton  du back avec le bouton cree dans le fichier xml portant ele nom btn_BakAbout
        this.btnBack = (Button) findViewById(R.id.btn_BackAbout);

        //oOn attribue les action au Bouton Back quand il y a une interaction avec celui-ci
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                finish(); //Met fin a l'activity et revient donc à l'activirté précédement utilisée
            }
        });
    }
}