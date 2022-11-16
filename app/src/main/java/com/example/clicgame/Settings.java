package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    private Button btnMusic;
    private Button btnSkin;
    private Button btnAbout;
    private Button btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.btnMusic = (Button) findViewById(R.id.btn_Music);
        this.btnSkin = (Button) findViewById(R.id.btn_Skin);
        this.btnAbout = (Button) findViewById(R.id.btn_About);
        this.btnBack = (Button) findViewById(R.id.btn_Back);

        //Bouton Music
        btnMusic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Music.class));
            }
        });

        //Bouton Skin
        btnSkin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Skin.class));
            }
        });

        //Bouton About
        btnAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), About.class));
            }
        });

        //Bouton Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Back.class));
            }
        });
    }
}