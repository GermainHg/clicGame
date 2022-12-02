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
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
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
    TextView textScore, textTimer, textTimerInit, linkEasterEgg;
    private Button btnBack;
    int score = 0;
    private static final long timer = 30000;
    int height, width;
    SharedPreferences sp;
    CountDownTimer mCountDownTimer, mCountDownTimerInit;
    boolean mTimerRunning;
    private long mTimeLeftInMillis = timer;
    private long mTimeLeftInMillisInit = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        imgBtnTarget = (ImageView) findViewById(R.id.imageButton);
        textScore = findViewById(R.id.titleScore);
        textScore.setText("Score : " + String.valueOf(score));
        textTimerInit = findViewById(R.id.titleTimerInit);
        linkEasterEgg = findViewById(R.id.tVEasterEgg);
        textTimer = findViewById(R.id.titleTimer);
        this.btnBack = (Button) findViewById(R.id.btn_Back);
        startTimerInit();
        //startTimer();
        updateCountDownText();

        linkEasterEgg.setVisibility(View.INVISIBLE);
        btnBack.setVisibility(View.INVISIBLE);

        sp = getSharedPreferences("UserProfil", Context.MODE_PRIVATE);

        //Bouton back eater egg
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                MediaPlayer.create(Play.this, R.raw.wtgd).start();
                }
        });

        imgBtnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Play.this, "+1", Toast.LENGTH_SHORT).show();
                MediaPlayer.create(Play.this, R.raw.pop).start();
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
                if (score == 1) {
                    linkEasterEgg.setVisibility(View.VISIBLE);
                    linkEasterEgg.setMovementMethod(LinkMovementMethod.getInstance());
                    //ajouter un bouton back
                    btnBack.setVisibility(View.VISIBLE);
                }
                //RETOUR EN ARRIERE
                else {
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
        int secondsInit = (int) (mTimeLeftInMillisInit / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "Time : %02d", seconds);
        String timeLeftFormattedInit = String.format(Locale.getDefault(), "Get ready ! : %02d", secondsInit);
        textTimer.setText(timeLeftFormatted);
        textTimerInit.setText(timeLeftFormattedInit);
    }

    private void startTimerInit() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        mCountDownTimerInit = new CountDownTimer(mTimeLeftInMillisInit, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillisInit = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                textTimerInit.setVisibility(View.INVISIBLE);
                startTimer();
                mTimerRunning = false;
            }
        }.start();
        mTimerRunning = true;
    }


    // arret du timer qd play est quittée
    @Override
    protected void onDestroy() {
        super.onDestroy();

        //mCountDownTimer.cancel();
        mCountDownTimerInit.cancel();
        MediaPlayer.create(Play.this, R.raw.wtgd).start();
        Toast.makeText(this, "Game ended", Toast.LENGTH_SHORT).show();
        //LogData("onDestroy Called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        //LogData("onPause Called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        //LogData("onResume Called");
    }

    /*void LogData(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        Log.d("TAG", data);
    }*/
}