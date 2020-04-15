package com.example.sc3testnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityStatistiques extends AppCompatActivity {
    private TextView gNbTentatives;
    private Button gButtonRejouer;
    private Intent intent;
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

        intent=getIntent();

        //il faut préciser le i provient de quelle classe
        i=intent.getIntExtra("i",i);

        int nb = 10-i;

        gNbTentatives = (TextView) findViewById(R.id.nbTentatives);
        gNbTentatives.setText("Vous avez effectué " + nb + " Tentatives !");
        gButtonRejouer = (Button) findViewById(R.id.buttonRejouer);
        gButtonRejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);

        //putExtra permet de récupérer le pseudo saisit par l'utilisateur
        intent.putExtra("Pseudo",gButtonRejouer.getText().toString());

        startActivity(intent);
    }
}
