package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


public class Records extends AppCompatActivity {
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        TextView topScore, topName;
        topScore = findViewById(R.id.txtTopScore);
        topName = findViewById(R.id.txtTopName);


        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserProfil", Context.MODE_PRIVATE);

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




        int[] tabScore = {top1, top2, top3, top4, top5, top6, top7, top8, top9, top10};
        String[] tabName = new String[]{topN1, topN2, topN3, topN4, topN5, topN6, topN7, topN8, topN9, topN10};


        for (int i = 0; i < tabScore.length-1; i++) {
            topScore.append(String.valueOf(tabScore[i]) + "\n");
        }
        for (int i = 0; i < tabName.length-1; i++) {
            topName.append(String.valueOf(tabName[i]) + "\n");
        }
    }
}