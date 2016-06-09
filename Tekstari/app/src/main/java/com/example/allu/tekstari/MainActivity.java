package com.example.allu.tekstari;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    public NimiJaNumeroDatabase kanta;
    public static ArrayList<String> nimiJaNumero = new ArrayList<>();
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lisaaHlo = (Button) findViewById(R.id.btnLisaa);

        kanta = new NimiJaNumeroDatabase(getApplicationContext());

       // kanta.poistaKaikki();

        if(kanta.haeKaikki() != null && kanta.haeKaikki().size() > 0) {
            nimiJaNumero = kanta.haeKaikki();
            kanta.puraKantayhteys();
        }

        if(nimiJaNumero != null && nimiJaNumero.size() > 0) {
            setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nimiJaNumero.toArray(new String[1])));
        }


        assert lisaaHlo != null;
        lisaaHlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lisaa = new Intent(getApplicationContext(), LisaaHlo.class);
                startActivity(lisaa);
            }
        });





    }


}
