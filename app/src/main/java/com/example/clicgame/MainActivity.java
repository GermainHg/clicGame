package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay;
    private Button btnSettings;
    private Button btnRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.btnPlay = (Button) findViewById(R.id.btn_Play);
        this.btnSettings = (Button) findViewById(R.id.btn_Settings);
        this.btnRecords= (Button) findViewById(R.id.btn_Records);

        //Bouton Play
        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Username.class));
            }
        });

        //Bouton Records
        btnRecords.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Records.class));
            }
        });

        //Bouton Settings
        btnSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Settings.class));
            }
        });
    }
} ///tristanT lotostite