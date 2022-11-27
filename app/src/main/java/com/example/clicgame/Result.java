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
import java.util.Arrays;

public class Result extends AppCompatActivity {

    private Button btnBack, btnReplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int valD = 7;
        //Recuperer donnees SharedPreferences
        TextView userName, scoreFinal, classe;
        userName = findViewById(R.id.txtUsername);
        scoreFinal = findViewById(R.id.txtScore);
        classe = findViewById(R.id.txtClassement);

        this.btnBack = (Button) findViewById(R.id.btn_Back);
        this.btnReplay = (Button) findViewById(R.id.btn_Retry);






        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserProfil", Context.MODE_PRIVATE);
        String name = sp.getString("name", "");
        int score = sp.getInt(getString(R.string.Party_Score), 0);
        /*int top1 = sp.getInt(getString(R.string.s1), 1);
        int top2 = sp.getInt(getString(R.string.s2), 1);
        int top3 = sp.getInt(getString(R.string.s3), 1);
        int top4 = sp.getInt(getString(R.string.s4), 1);
        int top5 = sp.getInt(getString(R.string.s5), 1);
        int top6 = sp.getInt(getString(R.string.s6), 1);
        int top7 = sp.getInt(getString(R.string.s7), 1);
        int top8 = sp.getInt(getString(R.string.s8), 1);
        int top9 = sp.getInt(getString(R.string.s9), 1);
        int top10 = sp.getInt(getString(R.string.s10), 1);*/
/*
        String topN1 = sp.getString(getString(R.string.n1),"");
        String topN2 = sp.getString(getString(R.string.n2),"");
        String topN3 = sp.getString(getString(R.string.n3),"");
        String topN4 = sp.getString(getString(R.string.n4),"");
        String topN5 = sp.getString(getString(R.string.n5),"");
        String topN6 = sp.getString(getString(R.string.n6),"");
        String topN7 = sp.getString(getString(R.string.n7),"");
        String topN8 = sp.getString(getString(R.string.n8),"");
        String topN9 = sp.getString(getString(R.string.n9),"");
        String topN10 = sp.getString(getString(R.string.n10),"");*/
        //SharedPreferences sp = getSharedPreferences("UserProfil", Context.MODE_PRIVATE);
        //name = edit_msg.getText().toString();
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("new", score );
        /*editor.putInt("1", valD);
        editor.putInt("2", valD);
        editor.putInt("3", valD);
        editor.putInt("4", valD);*/
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






        int[] tab = {top1, top2, top3, top4, top5, top6, top7, top8, top9, top10, score};
        //int[] tab = {top1, top2, top3, top4, score};
        //int[] tab = {4, 6,3,3,8,7,7,5, score};

        tri(tab);

        rangementShared(tab, sp);

        /*for (int i = 0; i<=9; i++){
            SharedPreferences.Editor editor = sp.edit();
            String topi = "top" + String.valueOf(i);
            editor.putInt(getString(R.string.String(topi)), tab[i]);
            editor.commit();
        }*/


        for (int i = 0; i < tab.length-1; i++) {
            classe.append(String.valueOf(tab[i]) + "\n");
        }


        //affiche le score et name
        userName.setText("name" + name);
        scoreFinal.setText("score " + String.valueOf(score));


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


    void rangementShared(int[] pTab, SharedPreferences psp) {
        SharedPreferences.Editor editor = psp.edit();
/*
        editor.putInt(getString(R.string.s1), pTab[0]);
        editor.putInt(getString(R.string.s2), pTab[1]);
        editor.putInt(getString(R.string.s3), pTab[2]);
        editor.putInt(getString(R.string.s4), pTab[3]);
        editor.putInt(getString(R.string.s5), pTab[4]);
        editor.putInt(getString(R.string.s6), pTab[5]);
        editor.putInt(getString(R.string.s7), pTab[6]);
        editor.putInt(getString(R.string.s8), pTab[7]);
        editor.putInt(getString(R.string.s9), pTab[8]);
        editor.putInt(getString(R.string.s10), pTab[9]);*/

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

        editor.commit();
    }


    void tri(int[] ptTab) {
        for (int i = 0; i < ptTab.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < ptTab.length; j++) {
                if (ptTab[j] > ptTab[index]) {
                    index = j;
                }
            }
            int min = ptTab[index];
            ptTab[index] = ptTab[i];
            ptTab[i] = min;
        }
    }
}

