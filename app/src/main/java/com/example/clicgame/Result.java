package com.example.clicgame;
// Application réaliséé dans le cadre de l'unité [E4fe] 4E-LE1 IHM dévelopement d'une application Android
// Auteur : LESTIENNE Raphaël / HENG Germain / GUIRAUDOU Tristan
// Support : M.BENABOU

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
import java.util.Arrays;

public class Result extends AppCompatActivity {

    //Initialisation des objets
    private Button btnBack, btnReplay;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int valD = 7;

        //création des variables nécessaires au fonctionnement
        TextView userName, scoreFinal;

        //On associe les objets avec ceux qui ont ete cree dans le fichier xml
        userName = findViewById(R.id.txtUsername);
        scoreFinal = findViewById(R.id.txtScore);
        this.btnBack = (Button) findViewById(R.id.btn_Back);
        this.btnReplay = (Button) findViewById(R.id.btn_Retry);

        //Recuperer donnees stockées dans le SharedPreferences UserProfil
        // il s'agit d'une mémoire percistante
        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserProfil", Context.MODE_PRIVATE);
        // On extrait la donnée de la variable name dans un String pour pouvoir tratier la donnée
        // cette donnée name est le nom du joueru qui vient de jouer
        String name = sp.getString("name", "");
        // Idem pour la variable Party_score (cliquer sur les gillemets si le code ne s'ouvre pas)
        // il s'agit du socre qui vient d'être joué
        int score = sp.getInt(getString(R.string.Party_Score), 0);

        // on utilise le .editor pour pouvoir éditer le SharedPreferences
        SharedPreferences.Editor editor = sp.edit();

        // On ajoute au sp le score qui vient d'^tre fait par le joueur
        editor.putInt("new", score );

        // On  extrait chaque valeur de sp du classement courant dans des variables int pour les traiter plus tard
        int top1 = sp.getInt("1", 0);
        int top2 = sp.getInt("2", 0);
        int top3 = sp.getInt("3", 0);
        int top4 = sp.getInt("4", 0);
        int top5 = sp.getInt("5", 0);
        int top6 = sp.getInt("6", 0);
        int top7 = sp.getInt("7", 0);
        int top8 = sp.getInt("8", 0);
        int top9 = sp.getInt("9", 0);
        int top10 = sp.getInt("10", 0);

        // idem pour les nom du classement
        String topN1 = sp.getString("n1","");
        String topN2 = sp.getString("n2","");
        String topN3 = sp.getString("n3","");
        String topN4 = sp.getString("n4","");
        String topN5 = sp.getString("n5","");
        String topN6 = sp.getString("n6","");
        String topN7 = sp.getString("n7","");
        String topN8 = sp.getString("n8","");
        String topN9 = sp.getString("n9","");
        String topN10 = sp.getString("n10","");

        // on met les score et les noms du classement actuel dans 2 tableaux pour plus facielemnt traiter les scores et les noms
        // remarque on ajoute à ce tableau le score qui vient d'etre réalisé ainsi que le nom du player
        int[] tab = {top1, top2, top3, top4, top5, top6, top7, top8, top9, top10, score};
        String[] tN = new String[]{topN1, topN2, topN3, topN4, topN5, topN6, topN7, topN8, topN9, topN10, name};

        // appel de la fonction tri() qui va ranger dasn l'ordre décroissant les deux tableaux
        tri(tab,tN);
        // une fois le tri du tableau réalisé (donc mise ajour du classement avec le socre qui vient d'être joué) nous mettons a jour le sp en appelant la focntion rangementShared()
        rangementShared(tab, tN, sp);

        //affiche le score et name de la partie qui vient d'être jouée
        userName.setText("name : " + name);
        scoreFinal.setText("score : " + String.valueOf(score));


        //Bouton back
        btnBack.setOnClickListener(new View.OnClickListener() { //On definit l'action a realiser apres avoir appuie le bouton
            public void onClick(View view) {
                finish(); //Met fin a l'activity
            }
        });

        //Bouton replay
        btnReplay.setOnClickListener(new View.OnClickListener() { //On definit l'action a realiser apres avoir appuie le bouton
            public void onClick(View view) {
                finish(); //Met fin a l'activity
                startActivity(new Intent(getApplicationContext(), Username.class)); //On demarre une nouvelle activity
            }
        });
    }

    //put le classement à jour trié dans le sharePreferences
    void rangementShared(int[] pTab, String[] pTN, SharedPreferences psp) {
        // il est necessaire de faire un .edit() sur psp pour éditer le psp
        SharedPreferences.Editor editor = psp.edit();

        // nouveaux classmeent score
        editor.putInt("1", pTab[0]);
        editor.putInt("2", pTab[1]);
        editor.putInt("3", pTab[2]);
        editor.putInt("4", pTab[3]);
        editor.putInt("5", pTab[4]);
        editor.putInt("6", pTab[5]);
        editor.putInt("7", pTab[6]);
        editor.putInt("8", pTab[7]);
        editor.putInt("9", pTab[8]);
        editor.putInt("10", pTab[9]);
        // nouveau classement noms
        editor.putString("n1", pTN[0]);
        editor.putString("n2", pTN[1]);
        editor.putString("n3", pTN[2]);
        editor.putString("n4", pTN[3]);
        editor.putString("n5", pTN[4]);
        editor.putString("n6", pTN[5]);
        editor.putString("n7", pTN[6]);
        editor.putString("n8", pTN[7]);
        editor.putString("n9", pTN[8]);
        editor.putString("n10", pTN[9]);
        //en quelque sorte on ferme le edit() et on sauvegarde
        editor.commit();
    }

    // fonction de tri
    // fonction simple de rangement d'un tableau dasn l'ordre décroissant en utilisant les indices des tableaux
    void tri(int[] ptTab, String[] ptN) {
        for (int i = 0; i < ptTab.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < ptTab.length; j++) {
                if (ptTab[j] > ptTab[index]) {
                    index = j;
                }
            }
            int min = ptTab[index];
            String mon = ptN[index];

            ptTab[index] = ptTab[i];
            ptN[index] = ptN[i];

            ptTab[i] = min;
            ptN[i]=mon;
        }
    }
}

