package com.example.clicgame;
// Application réaliséé dans le cadre de l'unité [E4fe] 4E-LE1 IHM dévelopement d'une application Android
// Auteur : LESTIENNE Raphaël / HENG Germain / GUIRAUDOU Tristan
// Support : M.BENABOU
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

// menu des skins jouables
// on ambitionne de mettre ce menu en format gridview à l'avenir
public class Skin extends AppCompatActivity {

    //Initialisation des objets
    ImageView imgSkin1, imgSkin2, imgSkin3, imgSkin4, imgSkin5, imgSkin6;
    SharedPreferences sp;
    String img, cat, cat2, etrhehjy, tk1, chat5;
    private Button btnBack;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On associe la disposition du fichier xml avec l'activity
        setContentView(R.layout.activity_skin);

        //On associe l'objet bouton avec le bouton cree dans le fichier xml
        imgSkin1 = (ImageView) findViewById(R.id.img1);
        imgSkin2 = (ImageView) findViewById(R.id.img2);
        imgSkin3 = (ImageView) findViewById(R.id.img3);
        imgSkin4 = (ImageView) findViewById(R.id.img4);
        imgSkin5 = (ImageView) findViewById(R.id.img5);
        imgSkin6 = (ImageView) findViewById(R.id.img6);
        this.btnBack = (Button) findViewById(R.id.btn_Back);

        //on "ouvre" le sharedPreferences "UserProfil"
        sp = getSharedPreferences("UserProfil", Context.MODE_PRIVATE);

        //Algorithme primitif mais focntionel
        //Premier skin
        imgSkin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie sur l'item
                String newSkin = img;
                //on change la variable de skin qui est dans le shared preferences pour changer le skin en jeu
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 1 );
                editor.commit();
                Toast.makeText(Skin.this, "You've chosen a new skin !", Toast.LENGTH_SHORT).show(); // Show a Toast message on item  click

            }
        });

        //Deuxieme skin
        imgSkin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie sur l'item
                String newSkin = cat;
                //on change la variable de skin qui est dans le shared preferences pour changer le skin en jeu
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 2 );
                editor.commit();
                Toast.makeText(Skin.this, "You've chosen a new skin !", Toast.LENGTH_SHORT).show(); // Show a Toast message on item  click
            }
        });

        //Troisieme skin
        imgSkin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie sur l'item
                String newSkin = cat2;
                //on change la variable de skin qui est dans le shared preferences pour changer le skin en jeu
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 3 );
                editor.commit();
                Toast.makeText(Skin.this, "You've chosen a new skin !", Toast.LENGTH_SHORT).show(); // Show a Toast message on item  click
            }
        });

        //Quatrieme skin
        imgSkin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie sur l'item
                String newSkin = etrhehjy;
                //on change la variable de skin qui est dans le shared preferences pour changer le skin en jeu
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 4 );
                editor.commit();
                Toast.makeText(Skin.this, "You've chosen a new skin !", Toast.LENGTH_SHORT).show(); // Show a Toast message on item  click
            }
        });

        //Cinquieme skin
        imgSkin5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie sur l'item
                String newSkin = tk1;
                //on change la variable de skin qui est dans le shared preferences pour changer le skin en jeu
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 5 );
                editor.commit();
                Toast.makeText(Skin.this, "You've chosen a new skin !", Toast.LENGTH_SHORT).show(); // Show a Toast message on item  click
            }
        });

        //Sixieme skin
        imgSkin6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie sur l'item
                String newSkin = chat5;
                //on change la variable de skin qui est dans le shared preferences pour changer le skin en jeu
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skin", 6 );
                editor.commit();
                Toast.makeText(Skin.this, "You've chosen a new skin !", Toast.LENGTH_SHORT).show(); // Show a Toast message on item  click
            }
        });

        //Bouton Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie le bouton
                finish(); //Met fin a l'activity
            }
        });

    }
}
