package com.example.allu.masstext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final String MyPREF = "nimijanumero";
    public final String nimi = "name";
    public final String numero = "number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences pref = getSharedPreferences(MyPREF, Context.MODE_PRIVATE);
        ListView lista = (ListView) findViewById(R.id.listNimiHlo);
        ArrayList<String> nimetJaNumerot = new ArrayList<>();

       if(pref.getAll().size() > 0 && pref.getAll() != null) {
            for(int i = 0; i < pref.getAll().size(); i++) {
                String nam = pref.getString(nimi, null);
                String num = pref.getString(numero, null);
                nimetJaNumerot.add(nam + " " + num);
            }
           lista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nimetJaNumerot.toArray(new String[1])));
       }

        Button laheta = (Button) findViewById(R.id.btnLaheta);
        Button lisaa = (Button) findViewById(R.id.btnLisaa);

        assert lisaa != null;
        lisaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hlo = new Intent(getApplicationContext(), LisaaHlo.class);
                startActivity(hlo);
            }
        });
    }
}
