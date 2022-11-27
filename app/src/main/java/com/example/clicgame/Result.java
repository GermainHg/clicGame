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

        TextView userName, scoreFinal;

        userName = findViewById(R.id.txtUsername);
        scoreFinal = findViewById(R.id.txtScore);
        this.btnBack = (Button) findViewById(R.id.btn_Back);
        this.btnReplay = (Button) findViewById(R.id.btn_Retry);

        //Recuperer donnees SharedPreferences
        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserProfil", Context.MODE_PRIVATE);
        String name = sp.getString("name", "");
        int score = sp.getInt(getString(R.string.Party_Score), 0);

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("new", score );

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

        int[] tab = {top1, top2, top3, top4, top5, top6, top7, top8, top9, top10, score};
        String[] tN = new String[]{topN1, topN2, topN3, topN4, topN5, topN6, topN7, topN8, topN9, topN10, name};

        tri(tab,tN);
        rangementShared(tab, tN, sp);

        //affiche le score et name
        userName.setText("name : " + name);
        scoreFinal.setText("score : " + String.valueOf(score));


        //Bouton back
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
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

    //put le nouveau classement dans le shareP
    void rangementShared(int[] pTab, String[] pTN, SharedPreferences psp) {
        SharedPreferences.Editor editor = psp.edit();

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

        editor.commit();
    }


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

