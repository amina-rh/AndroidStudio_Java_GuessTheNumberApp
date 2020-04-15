package com.example.sc3testnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityDebutant extends AppCompatActivity {
    private Button gButtonValider;
    private TextView gMessageTentatives;
    private EditText gNombreSaisi;
    private TextView gMsgBienvenue;
    private int i=9;
    private Intent intent;
    private int nChance = (int) (Math.random()*10);

    public int getnChance() {
        return nChance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debutant);

        gButtonValider = (Button) findViewById(R.id.buttonValider);
        gMessageTentatives = (TextView) findViewById(R.id.MessageTentatives);
        gNombreSaisi = (EditText) findViewById(R.id.NombreSaisi);
        gMsgBienvenue = (TextView) findViewById(R.id.MsgBienvenue);

        Intent intent = getIntent();

        String pseudo = intent.getStringExtra("Pseudo");
        gMsgBienvenue.setText("Bonjour "+ pseudo +"!");


        gButtonValider.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //Convertir le Nombre saisi de string à int
                int nUtilisateur = Integer.parseInt(gNombreSaisi.getText().toString());

                String message = "";

                if (nUtilisateur == getnChance()) {
                    gButtonValider.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openActivityStatistiques();
                        }
                    });

                }
                else {

                    if (i > 0 && nUtilisateur > getnChance() ) {
                        gMessageTentatives.setText("Vous devez décrémenter ! \nIl vous reste " + i + " Tentatives !");
                    }

                    else if (i > 0 && nUtilisateur < getnChance()){
                        gMessageTentatives.setText("Vous devez incrémenter ! \nIl vous reste " + i + " Tentatives !");
                    }
                    else {
                        gMessageTentatives.setText("Perdu !");
                        gButtonValider.setText("Rejouer !");

                        gButtonValider.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openMainActivity();
                            }
                        });

                    }

                    i--;

                }
            }
        });


    }

    public void openActivityStatistiques(){
        Intent intent = new Intent(this, ActivityStatistiques.class);
        intent.putExtra("i",i);
        startActivity(intent);
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
