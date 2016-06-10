package com.example.allu.tekstari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LisaaHlo extends AppCompatActivity {

    public NimiJaNumeroDatabase kanta;
    EditText nimi;
    EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_hlo);

        kanta = new NimiJaNumeroDatabase(getApplicationContext());
        nimi = (EditText) findViewById(R.id.editNimi);
        numero = (EditText) findViewById(R.id.editNumero);
        Button lisaa = (Button) findViewById(R.id.btnHloLisays);

        assert lisaa != null;
        lisaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lisattavaNimi = nimi.getText().toString();
                String lisattavaNumero = numero.getText().toString();
                kanta.suoritaInsert(lisattavaNimi, lisattavaNumero);
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        });


       // kanta.suoritaInsert("Allu", "0503813892");
       // kanta.puraKantayhteys();
    }
}
