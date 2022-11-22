package com.example.clicgame;

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

    private Button btnGo;
    EditText  edit_msg;
    SharedPreferences sp;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        this.btnGo = (Button) findViewById(R.id.btn_Go);
        edit_msg = (EditText) findViewById(R.id.edit_msg);

        sp = getSharedPreferences("UserProfil", Context.MODE_PRIVATE);


        //Bouton GO
        btnGo.setOnClickListener(new View.OnClickListener() {

            @Override
                public void onClick (View view){

                    if (TextUtils.isEmpty(edit_msg.getText().toString())) {
                        Toast.makeText(Username.this, "Please enter a username !", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        //get username + associer score
                        name = edit_msg.getText().toString();
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("name", name);
                        editor.commit();

                        startActivity(new Intent(getApplicationContext(), Play.class));
                }
            }

        });
    }
}
