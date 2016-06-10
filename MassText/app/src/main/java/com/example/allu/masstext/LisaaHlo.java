package com.example.allu.masstext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LisaaHlo extends AppCompatActivity {

    public final String MyPREF = "nimijanumero";
    public final String nimi = "name";
    public final String numero = "number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_hlo);

        final SharedPreferences pref = getSharedPreferences(MyPREF, Context.MODE_PRIVATE);

        Button add = (Button) findViewById(R.id.btnAdd);

        assert add != null;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nimiTxt = (EditText) findViewById(R.id.editNimi);
                String nimiToS = nimiTxt.getText().toString();
                EditText numeroTxt = (EditText) findViewById(R.id.editNumero);
                String numeroToS = numeroTxt.getText().toString();
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(nimi, nimiToS);
                editor.putString(numero, numeroToS);
                editor.commit();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}
