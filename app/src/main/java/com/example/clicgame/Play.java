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

    //Initialisation des variables
    private ImageView imgBtnTarget,imgUp;
    private TextView textScore, textTimer, textTimerInit, linkEasterEgg;
    private Button btnBack;
    private static final long timer = 30000;
    int score = 0;
    int height, width;
    SharedPreferences sp;
    CountDownTimer mCountDownTimer, mCountDownTimerInit;
    boolean mTimerRunning;
    private long mTimeLeftInMillis = timer;
    private long mTimeLeftInMillisInit = 4000;
    boolean isOver = false;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On associe la disposition du fichier xml avec l'activity
        setContentView(R.layout.activity_play);

        //On associe les objets avec ceux qui ont ete cree dans le fichier xml
        imgBtnTarget = (ImageView) findViewById(R.id.imageButton);
        imgUp = (ImageView) findViewById(R.id.Bg);
        textScore = findViewById(R.id.titleScore);
        textScore.setText("Score : " + String.valueOf(score));
        textTimerInit = findViewById(R.id.titleTimerInit);
        linkEasterEgg = findViewById(R.id.tVEasterEgg);
        textTimer = findViewById(R.id.titleTimer);
        this.btnBack = (Button) findViewById(R.id.btn_Back);

        //Initalisation du timer
        startTimerInit();
        //Affichage des timers
        updateCountDownText();

        //On rend invisible le lien de l'EasterEgg et du bouton back
        linkEasterEgg.setVisibility(View.INVISIBLE);
        btnBack.setVisibility(View.INVISIBLE);

        //On recupere le skin selectionne dans l'option Skin via les SharedPreferences
        sp = getSharedPreferences("UserProfil", Context.MODE_PRIVATE);
        int imgSkin = sp.getInt("skin",1);

        //On definit le skin choisi par le joueur
        switch(imgSkin) {
            case 1:
                imgBtnTarget.setImageResource(R.drawable.img);
                break;
            case 2:
                imgBtnTarget.setImageResource(R.drawable.cat);
                break;
            case 3:
                imgBtnTarget.setImageResource(R.drawable.cat2);
                break;
            case 4:
                imgBtnTarget.setImageResource(R.drawable.etrhehjy);
                break;
            case 5:
                imgBtnTarget.setImageResource(R.drawable.tk1);
                break;
            case 6:
                imgBtnTarget.setImageResource(R.drawable.chat5);
                break;
        }

        //Bouton back eater egg
        btnBack.setOnClickListener(new View.OnClickListener() { //On definit l'action a realiser apres avoir appuie le bouton
            @Override
            public void onClick(View view) {
                finish(); //Met fin a l'activity
                }
        });

        //Image cible a toucher
        imgBtnTarget.setOnClickListener(new View.OnClickListener() { //On definit l'action a realiser apres avoir appuie l'image
            @Override
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie la cible
                MediaPlayer.create(Play.this, R.raw.pop).start(); //Joue un fichier audio
                score++; //Incrementation du score

                //On fait changer la position de l'image
                width = random(getScreenWidth()-300);
                height = random(getScreenHeight()-400);
                imgBtnTarget.setX(width);
                imgBtnTarget.setY(height);

                //Mise a jour le score
                textScore.setText("Score : " + String.valueOf(score));
            }
        });

        //Image en arriere plan
        imgUp.setOnClickListener(new View.OnClickListener() { //On definit l'action a realiser apres avoir appuie l'image
            @Override
            public void onClick(View view) { //On definit l'action a realiser apres avoir appuie sur l'arriere plan
                MediaPlayer.create(Play.this, R.raw.miss).start(); //Joue un fichier audio
                score--; //Decrementation du score

                //Mise a jour le score
                textScore.setText("Score : " + String.valueOf(score));

            }
        });
    }

    //Methode pour recuperer la largeur de l'ecran
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    //Methode pour recuperer la largeur de l'ecran
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    //Generation aleatoire d'un entier
    private int random(int px ){
        final int random = new Random().nextInt(px) + 0; // nextInt((max-min)+1) + min
        return random;
    }

    //Affichage des timers
    private void updateCountDownText() {
        //Timer 4 secondes
        int secondsInit = (int) (mTimeLeftInMillisInit / 1000) % 60;
        String timeLeftFormattedInit = String.format(Locale.getDefault(), "Get ready ! : %02d", secondsInit);
        textTimerInit.setText(timeLeftFormattedInit);

        //Timer 30 secondes
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "Time : %02d", seconds);
        textTimer.setText(timeLeftFormatted);
    }

    //Timer 30 secondes
    private void startTimer() {

        //On demarre le timer
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) { //Minuteur
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
                public void onFinish() { //Actions a deinir lorsque le timer est fini
                mTimerRunning = false;

                //EasterEgg
                if (score == 1) {
                    linkEasterEgg.setVisibility(View.VISIBLE);
                    linkEasterEgg.setMovementMethod(LinkMovementMethod.getInstance()); //Lien cliquable
                    btnBack.setVisibility(View.VISIBLE); //Rend visible le bouton Back
                }

                else {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt(getString(R.string.Party_Score), score);
                    editor.commit();

                    finish(); //Met fin a l'activity
                    startActivity(new Intent(getApplicationContext(), Result.class)); //On demarre une nouvelle activity
                }
            }
        }.start();
        mTimerRunning = true;
    }

    //Timer 4 secondes
    private void startTimerInit() {
        //On desactive la possibilite d'interagir avec l'ecran
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        //On demarre le timer
        mCountDownTimerInit = new CountDownTimer(mTimeLeftInMillisInit, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillisInit = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() { //Actions a deinir lorsque le timer est fini
                //On reactive la possibilite d'interagir avec l'ecran
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                //On rend invisible le timer 4 secondes
                textTimerInit.setVisibility(View.INVISIBLE);

                //On lance le timer 30 secondes
                startTimer();

                //Timer 4 seconds is over
                isOver = true;
            }
        }.start();
    }

    //Actions a definir lorsque l'activity passe en arriere plan
    @Override
    protected void onDestroy() {
        super.onDestroy();

        //Annulation du timer 4 secondes
        mCountDownTimerInit.cancel();

        //Si le joueur clique sur la retour navigation alors qu'il est en pleine partie
        if(this.isFinishing() && mTimerRunning == true) mCountDownTimer.cancel(); //On annule le timer 30s

        MediaPlayer.create(Play.this, R.raw.wtgd).start(); //Joue un fichier audio
        Toast.makeText(this, "Game ended", Toast.LENGTH_SHORT).show(); //Affiche un toast
    }
}