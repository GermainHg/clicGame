package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {

    //Initialisation d'un bouton
    private Button btnBack;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On associe la disposition du fichier xml avec l'activity
        setContentView(R.layout.activity_about);

        //On associe l'objet bouton avec le bouton cree dans le fichier xml
        this.btnBack = (Button) findViewById(R.id.btn_BackAbout);

        //Bouton Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                finish(); //Met fin a l'activity
            }
        });
    }
}