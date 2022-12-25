package com.example.clicgame;
// Application réaliséé dans le cadre de l'unité [E4fe] 4E-LE1 IHM dévelopement d'une application Android
// Auteur : LESTIENNE Raphaël / HENG Germain / GUIRAUDOU Tristan
// Support : M.BENABOU
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Username extends AppCompatActivity {

    //Initialisation des objets
    private Button btnGo;
    EditText  edit_msg;
    SharedPreferences sp;
    String name;

    //Actions a definir a la creation de l'activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        //On associe la disposition du fichier xml avec l'activity
        this.btnGo = (Button) findViewById(R.id.btn_Go);
        edit_msg = (EditText) findViewById(R.id.edit_msg);

        // on "ouvre" un sp pour y sauvegarder ci-après le nom du joueur et pouvoir le réafficher une fois la partie finie
        sp = getSharedPreferences("UserProfil", Context.MODE_PRIVATE);

        // Bouton GO
        btnGo.setOnClickListener(new View.OnClickListener() {

            @Override
                public void onClick (View view){ //On definit l'action a realiser apres avoir appuie le bouton

                    if (TextUtils.isEmpty(edit_msg.getText().toString())) { //si le joeur ne rentre pas de nom dans la barre dédiée il ne peut jouer et un toast se présente à lui pour lui signaler
                        Toast.makeText(Username.this, "Please enter a username !", Toast.LENGTH_SHORT).show(); // Show a Toast message on item  click
                    }

                    else {
                        // On enregistre dasn le sp le nom du joeur que l'utilisateur vient de rentrer dans la barre dédiée
                        name = edit_msg.getText().toString();
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("name", name);
                        editor.commit();

                        finish(); //Met fin a l'activity
                        startActivity(new Intent(getApplicationContext(), Play.class)); //On demarre une nouvelle activity
                    }
            }

        });
    }
}
