package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private static final long timer = 30000;
    int height, width, tailleX, tailleY;
    int randomX;
    int randomY;

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

        //tailleX=getScreenWidth()/2;
        //tailleY=getScreenHeight()/2;
        linkEasterEgg.setVisibility(View.INVISIBLE);

        imgBtnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Play.this, "+1", Toast.LENGTH_SHORT).show();
                score++;
                //randomX = random();
                //randomY = random();
                width = random(getScreenWidth()-300);
                height = random(getScreenHeight()-400);
                //width = getScreenWidth();
                //height = getScreenHeight();
                textScore.setText("Score : " + String.valueOf(score));
                imgBtnTarget.setX(width);
                imgBtnTarget.setY(height);
                //random = new Random().nextInt(76) + 25;

            }
        });
    }

    //public int percentage(int px, float rand){
      //  float temp = (float) px;
        //int result = Math.round(temp * rand/100);
        //return result;
    //}

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
                    //line hypertext
                    //linkEasterEgg.setX(tailleX);
                    //linkEasterEgg.setY(tailleY);
                    linkEasterEgg.setVisibility(View.VISIBLE);
                    linkEasterEgg.setMovementMethod(LinkMovementMethod.getInstance());
                    //ajouter un bouton back
                }
                //RETOUR EN ARRIERE
                else{
                startActivity(new Intent(getApplicationContext(), Result.class));
                }
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDownText() {
        //int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "Time : %02d", seconds);
        textTimer.setText(timeLeftFormatted);
    }
}