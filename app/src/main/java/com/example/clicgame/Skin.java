package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Skin extends AppCompatActivity {
    ImageView imgSkin1, imgSkin2, imgSkin3, imgSkin4, imgSkin5, imgSkin6;
    SharedPreferences sp;
    String img, cat, cat2, etrhehjy, tk1, chat5;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);


        imgSkin1 = (ImageView) findViewById(R.id.img1);
        imgSkin2 = (ImageView) findViewById(R.id.img2);
        imgSkin3 = (ImageView) findViewById(R.id.img3);
        imgSkin4 = (ImageView) findViewById(R.id.img4);
        imgSkin5 = (ImageView) findViewById(R.id.img5);
        imgSkin6 = (ImageView) findViewById(R.id.img6);
        this.btnBack = (Button) findViewById(R.id.btn_Back);

        sp = getSharedPreferences("UserProfil", Context.MODE_PRIVATE);

        imgSkin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSkin = img;

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 1 );
                editor.commit();
                Toast.makeText(Skin.this, "You choosed a new skin !", Toast.LENGTH_SHORT).show();

            }
        });


        imgSkin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSkin = cat;

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 2 );
                editor.commit();
                Toast.makeText(Skin.this, "You choosed a new skin !", Toast.LENGTH_SHORT).show();
            }
        });


        imgSkin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSkin = cat2;

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 3 );
                editor.commit();
                Toast.makeText(Skin.this, "You choosed a new skin !", Toast.LENGTH_SHORT).show();
            }
        });


        imgSkin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSkin = etrhehjy;

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 4 );
                editor.commit();
                Toast.makeText(Skin.this, "You choosed a new skin !", Toast.LENGTH_SHORT).show();
            }
        });


        imgSkin5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSkin = tk1;

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 5 );
                editor.commit();
                Toast.makeText(Skin.this, "You choosed a new skin !", Toast.LENGTH_SHORT).show();
            }
        });

        imgSkin6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSkin = chat5;

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 6 );
                editor.commit();
                Toast.makeText(Skin.this, "You choosed a new skin !", Toast.LENGTH_SHORT).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });

    }
}
