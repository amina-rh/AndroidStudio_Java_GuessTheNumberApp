package com.example.sc3testnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private Button gButtonDeb;
    private Button gButtonInter;
    private Button gButtonExpert;
    private EditText gTextSaisi1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FloatingActionButton
        FloatingActionButton gFab = findViewById(R.id.fab);
        gFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Veuillez choisir votre niveau", Toast.LENGTH_SHORT).show();

            }
        });


                gButtonDeb = (Button) findViewById(R.id.buttonDeb);
        gButtonDeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityDebutant();
            }
        });

        gButtonInter = (Button) findViewById(R.id.buttonInt);
        gButtonInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInter();
            }
        });

        gButtonExpert = (Button) findViewById(R.id.buttonExp);
        gButtonExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityExpert();
            }
        });

        gTextSaisi1 = (EditText) findViewById(R.id.textsaisi1);
    }

    public void openActivityDebutant(){
        Intent intent = new Intent(this, ActivityDebutant.class);

        //putExtra permet de récupérer le pseudo saisit par l'utilisateur
        intent.putExtra("Pseudo",gTextSaisi1.getText().toString());

        startActivity(intent);
    }

    public void openActivityInter(){
        Intent intent = new Intent(this, ActivityInter.class);
        //putExtra permet de récupérer le pseudo saisit par l'utilisateur
        intent.putExtra("Pseudo",gTextSaisi1.getText().toString());
        startActivity(intent);
    }

    public void openActivityExpert(){
        Intent intent = new Intent(this, ActivityExpert.class);
        //putExtra permet de récupérer le pseudo saisit par l'utilisateur
        intent.putExtra("Pseudo",gTextSaisi1.getText().toString());
        startActivity(intent);
    }

}




