package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView userName, scoreFinal;

        userName = findViewById(R.id.txtUsername);
        scoreFinal = findViewById(R.id.txtScore);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserProfil", Context.MODE_PRIVATE);
        String name = sp.getString("name", "");
        int score = sp.getInt(getString(R.string.Party_Score),0);

        userName.setText(name);
        scoreFinal.setText("score " + String.valueOf(score));

    }
}