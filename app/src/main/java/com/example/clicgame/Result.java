package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private Button btnBack, btnReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Recuperer donnees SharedPreferences
        TextView userName, scoreFinal;

        userName = findViewById(R.id.txtUsername);
        scoreFinal = findViewById(R.id.txtScore);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserProfil", Context.MODE_PRIVATE);
        String name = sp.getString("name", "");
        int score = sp.getInt(getString(R.string.Party_Score),0);

        userName.setText(name);
        scoreFinal.setText("score " + String.valueOf(score));

        this.btnBack = (Button) findViewById(R.id.btn_Back);
        this.btnReplay  = (Button)  findViewById(R.id.btn_Retry);

        //Bouton back
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        //Bouton replay
        btnReplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), Username.class));
            }
        });
    }
}