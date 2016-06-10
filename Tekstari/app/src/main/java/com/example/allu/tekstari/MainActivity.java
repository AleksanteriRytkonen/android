package com.example.allu.tekstari;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    public NimiJaNumeroDatabase kanta;
    public static ArrayList<String> nimiJaNumero = new ArrayList<>();
    public static ArrayList<String> numerot = new ArrayList<>();
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lisaaHlo = (Button) findViewById(R.id.btnLisaa);
        Button poistaKaikki = (Button) findViewById(R.id.btnPoista);
        Button laheta = (Button) findViewById(R.id.btnLaheta);

        kanta = new NimiJaNumeroDatabase(getApplicationContext());
        nimiJaNumero.add("");
        paivita();


        assert laheta != null;
        laheta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                EditText viesti = (EditText) findViewById(R.id.editLaheta);
                String viestiTeksti = viesti.getText().toString();
                for(String s : numerot) {
                    smsManager.sendTextMessage(s, null, viestiTeksti, null, null);
                }
                Toast.makeText(MainActivity.this,"Viesti lähetetty", Toast.LENGTH_LONG).show();

            }
        });

        assert poistaKaikki != null;
        poistaKaikki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kanta.poistaKaikki();
                nimiJaNumero.clear();
                nimiJaNumero.add("");
                paivita();
            }
        });


        assert lisaaHlo != null;
        lisaaHlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lisaa = new Intent(getApplicationContext(), LisaaHlo.class);
                startActivity(lisaa);
            }
        });

    }

    public void paivita() {
        if(kanta.haeKaikki() != null && kanta.haeKaikki().size() > 0){
            nimiJaNumero = kanta.haeKaikki();
            numerot = kanta.haeNumerot();
        }
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nimiJaNumero.toArray(new String[1])));


    }


}
