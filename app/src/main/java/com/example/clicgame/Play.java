package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;
import android.text.method.LinkMovementMethod;
import java.util.Locale;
import java.util.Random;
import java.net.URI;


public class Play extends AppCompatActivity {

    ImageView imgBtnTarget;
    TextView textScore, textTimer, linkEasterEgg;
    int score = 0;
    //int finalScore;
    private static final long timer = 30000;
    int height, width;
    SharedPreferences sp;
    CountDownTimer mCountDownTimer;
    boolean mTimerRunning;
    private long mTimeLeftInMillis = timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        imgBtnTarget = (ImageView) findViewById(R.id.imageButton);
        textScore = findViewById(R.id.titleScore);
        textScore.setText("Score : " + String.valueOf(score));
        linkEasterEgg = findViewById(R.id.tVEasterEgg);
        textTimer = findViewById(R.id.titleTimer);
        startTimer();
        updateCountDownText();

        linkEasterEgg.setVisibility(View.INVISIBLE);

        sp = getSharedPreferences("UserProfil", Context.MODE_PRIVATE);

        imgBtnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Play.this, "+1", Toast.LENGTH_SHORT).show();
                score++;
                width = random(getScreenWidth()-300);
                height = random(getScreenHeight()-400);
                textScore.setText("Score : " + String.valueOf(score));
                imgBtnTarget.setX(width);
                imgBtnTarget.setY(height);
            }
        });
    }

    //get taille de l'écran en pixel
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    private int random(int px ){
        final int random = new Random().nextInt(px) + 0; // nextInt((max-min)+1) + min
        return random;
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                mTimerRunning = false;
                //EasterEgg
                if (score == 1){
                    linkEasterEgg.setVisibility(View.VISIBLE);
                    linkEasterEgg.setMovementMethod(LinkMovementMethod.getInstance());
                    //ajouter un bouton back
                }
                //RETOUR EN ARRIERE
                else{
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt(getString(R.string.Party_Score), score);
                    editor.commit();

                    finish();
                    startActivity(new Intent(getApplicationContext(), Result.class));
                }
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDownText() {
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "Time : %02d", seconds);
        textTimer.setText(timeLeftFormatted);
    }


    // arret du timer qd play est quittée
    @Override
    protected void onDestroy() {
        super.onDestroy();

        mCountDownTimer.cancel();
        Toast.makeText(this, "Game ended", Toast.LENGTH_SHORT).show();
        //LogData("onDestroy Called");
    }
}