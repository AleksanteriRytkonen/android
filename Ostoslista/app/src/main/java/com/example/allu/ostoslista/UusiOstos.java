package com.example.allu.ostoslista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UusiOstos extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uusi_ostos);
        Button lisaa = (Button) findViewById(R.id.btnLisaa);
        assert lisaa != null;

        lisaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText lisaaRuoka = (EditText) findViewById(R.id.addFood);
                String ruoka = lisaaRuoka.getText().toString();

                Intent ol = new Intent(getApplicationContext(), Ostoslista.class);
                startActivity(ol);
            }
        });


    }

}
