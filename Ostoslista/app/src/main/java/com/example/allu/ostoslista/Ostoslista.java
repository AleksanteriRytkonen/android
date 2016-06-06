package com.example.allu.ostoslista;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class Ostoslista extends ListActivity {


    public Safkat safkat = new Safkat();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ostoslista);

        safkat.lisaa("Maito");
        safkat.lisaa("Vesi");

        if(safkat.getRuokalista() != null && safkat.getRuokalista().size() > 0) {
            setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,safkat.getRuokalista().toArray(new String[1])));
        }
    }






}