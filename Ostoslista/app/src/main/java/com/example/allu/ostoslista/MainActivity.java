package com.example.allu.ostoslista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ostoslista = (Button) findViewById(R.id.btnOstoslista);
        ostoslista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ostosL = new Intent(getApplicationContext(),Ostoslista.class);
                startActivity(ostosL);
            }
        });

        //Intent ostoslista = new Intent(this, Ostoslista.class);
        //startActivity(ostoslista);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.UusiOstos:
                Intent uusiOstos = new Intent(getApplicationContext(), UusiOstos.class);
                startActivity(uusiOstos);
                return true;
            case R.id.Ohje:
                Intent ohje = new Intent(this, Ohje.class);
                startActivity(ohje);
                return true;
        }
        return true;
    }
}
