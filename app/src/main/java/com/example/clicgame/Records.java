package com.example.clicgame;
// Application réaliséé dans le cadre de l'unité [E4fe] 4E-LE1 IHM dévelopement d'une application Android
// Auteur : LESTIENNE Raphaël / HENG Germain / GUIRAUDOU Tristan
// Support : M.BENABOU

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

// cette ativity sert à afficher le classement précédement calculé après chaque partie
public class Records extends AppCompatActivity {
    //on crée un objet shared preferences pour sotcker le classement
    SharedPreferences sp;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        // création des variables nécessaires pour la gestion du classement
        TextView topScore, topName;

        // On associe certaines de nos variables précedentes à des objets txt du fichier xml de l'activity Records
        topScore = findViewById(R.id.txtTopScore);
        topName = findViewById(R.id.txtTopName);

        // On ouvre l'endroit on sont stockées les informations que nous voulons traiter pour faire et afficher le classement des score avec le nom du user associé
        // il s'agit d'une mémoire percistante
        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserProfil", Context.MODE_PRIVATE);


        // On fait un getInt du classement enregistré dasn chacune des variables du shared preferences
        // Particularité des variables de stockage dans un sharedPreferences c'est que nous devons passer par une variable intermédiaire pour traiter la donnée
        // On met chacun des scores enregistrés dans une variable int pouvant être traitée dans un algorithme
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
        // Idem met chacun des noms associé à un score enregistrés dans une variable String pouvant être traitée dans un algorithme
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



        // Création de 2 tableaux dasn lesquels nous allons stocker les valeurs des score et des noms précédement extraits du sharedPreferences
        // Il y a 2 tableaux différents, 1 tableau pour es core et un tableau pour les Noms
        int[] tabScore = {top1, top2, top3, top4, top5, top6, top7, top8, top9, top10};
        String[] tabName = new String[]{topN1, topN2, topN3, topN4, topN5, topN6, topN7, topN8, topN9, topN10};

        // On ajoute dans topScore qui est affiché via le fichier xml chacun des scores du tableau (On converti chacun valeur du tableau en String)
        for (int i = 0; i < tabScore.length-1; i++) {
            topScore.append(String.valueOf(tabScore[i]) + "\n");
        }
        // On ajoute dans topName qui est affiché via le fichier xml chacun des noms du tableau
        for (int i = 0; i < tabName.length-1; i++) {
            topName.append(String.valueOf(tabName[i]) + "\n");
        }

        SharedPreferences.Editor editor = sp.edit();
        int score = sp.getInt(getString(R.string.Party_Score), 0);
        editor.putInt("new", score );
    }
}