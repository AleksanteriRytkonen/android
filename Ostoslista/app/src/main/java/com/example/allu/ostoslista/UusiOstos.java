package com.example.allu.ostoslista;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UusiOstos extends AppCompatActivity {


    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Ruoka = "foodKey";
    public SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uusi_ostos);
        Button lisaa = (Button) findViewById(R.id.btnLisaa);
        assert lisaa != null;

        final Intent os = new Intent(UusiOstos.this, Ostoslista.class);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final Context context = getApplicationContext();
        final String viesti = "Et lisännyt mitään";
        final int duration = Toast.LENGTH_LONG;
        sharedpreferences = getApplicationContext().getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);


        lisaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText lisaaRuoka = (EditText) findViewById(R.id.addFood);
                String ruoka = lisaaRuoka.getText().toString();
                if(ruoka == null || ruoka.equals("")) {
                    builder.setMessage("Älä lisää tyhjiä").setCancelable(false).setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            }).setNegativeButton("Lopeta", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id) {
                            Toast toast = Toast.makeText(context, viesti, duration);
                            toast.show();
                        }
                    });
                    builder.create();
                    builder.show();
                } else {
                    //Ostoslista.ostokset.add(ruoka);

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Ruoka, ruoka);
                    editor.apply();

                    startActivity(os);
                }
            }
        });


    }

}
