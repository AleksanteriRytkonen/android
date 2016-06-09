package com.example.allu.tekstari;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LisaaHlo extends AppCompatActivity {

    public NimiJaNumeroDatabase kanta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_hlo);

        kanta = new NimiJaNumeroDatabase(getApplicationContext());
        kanta.suoritaInsert("Allu", "0503813892");
        kanta.puraKantayhteys();
    }
}
