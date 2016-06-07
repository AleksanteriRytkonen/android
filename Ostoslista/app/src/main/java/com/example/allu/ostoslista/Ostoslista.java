package com.example.allu.ostoslista;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Map;

public class Ostoslista extends ListActivity {


    public static ArrayList<String> ostokset = new ArrayList<>();
    public SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ostoslista);

        //SharedPreferences prefs = getSharedPreferences(UusiOstos.MyPREFERENCES, Context.MODE_PRIVATE);
       //// String ruoka = prefs.getString("Ruoka", null);
       // ostokset.add(ruoka);


        SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        //String ruoka = sharedPreferences.getString("foodKey", "");

        Map<String, ?> allEntries = sharedPreferences.getAll();
        for(Map.Entry<String, ?> entry : allEntries.entrySet()) {
            ostokset.add(entry.getValue().toString());
        }


        //String ruoat = sharedPreferences.getAll().values().toString();
        //ostokset.add(ruoat);

       if(ostokset != null && ostokset.size() > 0) {
            setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ostokset.toArray(new String[1])));
        }

    }
    public void load(View view) {
        //SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        //String ruoka = sharedPreferences.getString("foodKey", "");
    }


}