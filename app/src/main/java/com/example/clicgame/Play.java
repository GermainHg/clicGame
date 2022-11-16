package com.example.clicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;
import java.util.Locale;

public class Play extends AppCompatActivity {

    ImageButton imgBtnTarget;
    TextView textScore, textTimer;
    int score = 0;
    private static final long timer = 30000;

    CountDownTimer mCountDownTimer;
    boolean mTimerRunning;
    private long mTimeLeftInMillis = timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        imgBtnTarget = (ImageButton) findViewById(R.id.imageButton);
        textScore = findViewById(R.id.titleScore);
        textScore.setText("Score : " + String.valueOf(score));

        textTimer = findViewById(R.id.titleTimer);
        startTimer();
        updateCountDownText();

        imgBtnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Play.this, "+1", Toast.LENGTH_SHORT).show();
                score++;
                textScore.setText("Score : " + String.valueOf(score));
            }
        });
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
                //RETOUR EN ARRIERE
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDownText() {
        //int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "Score : %02d", seconds);
        textTimer.setText(timeLeftFormatted);
    }

}