package com.example.allu.kalenterisovellus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestiAct extends AppCompatActivity {

    TextView vapaa;
    TextView tyo;
    TextView koulu;
    ArrayList<TextView> kalenteri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testi);
        /* ############### ALKUMÄÄRITTELYT ##################*/
        /* ############### ALKUMÄÄRITTELYT ##################*/

        kalenteri = new ArrayList<>();
        vapaa = (TextView) findViewById(R.id.textViewVapaa);
        tyo = (TextView) findViewById(R.id.textViewTyo);
        koulu = (TextView) findViewById(R.id.textViewKoulu);
        /* ############### Jokaisen textViewin lisääminen kalenteri ArrayListiin ##################*/
        for(int i = 1; i <= 25; i++) {
            String textViewIds = "textView" + i;
            int id = getResources().getIdentifier(textViewIds, "id", getPackageName());
            if(id != 0) {
                TextView tv = (TextView) findViewById(id);
                kalenteri.add(tv);
            }
        }

        /* ############### NAPPIEN TOIMINNALLISUUS ##################*/
        /* ############### NAPPIEN TOIMINNALLISUUS ##################*/

        assert tyo != null;
        assert koulu != null;
        assert vapaa != null;

        vapaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                halytys("#99ff99");
            }
        });

        tyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                halytys("#ff3300");
            }
        });

        koulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                halytys("#1a1aff");
            }
        });

        /* ############### ################ ##################*/
        /* ############### ################ ##################*/
        /* ############### ################ ##################*/
        /* ############### ################ ##################*/

    }

    public void halytys(final String vari) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hälytys").setCancelable(false).setPositiveButton("ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        for(TextView t : kalenteri) {
                            t.setBackgroundColor(Color.parseColor(vari));
                        }
                    }
                }).setNegativeButton("Lopeta", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.create().show();
    }

}
