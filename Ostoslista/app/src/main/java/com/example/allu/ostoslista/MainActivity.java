package com.example.allu.ostoslista;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;
//AppCompatActivity
public class MainActivity extends ListActivity {

    public ArrayList<String> ostokset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ostokset = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            ostokset.add("Ostos " + i );
        }
        if(ostokset != null && ostokset.size() > 0) {
            setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ostokset.toArray(new String[1])));
        }
/*
        Button uusiOstosBtn = (Button) findViewById(R.id.btnUusiOstos);
        uusiOstosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uusiOstos = new Intent(getApplicationContext(),UusiOstos.class);
                startActivity(uusiOstos);
            }
        });
        */
/*
        Button ohjeBtn = (Button) findViewById(R.id.btnOhje);
        ohjeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Ohje.class);
                startActivity(i);
            }
        });
*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.UusiOstos:
                Intent uusiOstos = new Intent(getApplicationContext(),UusiOstos.class);
                startActivity(uusiOstos);
                return true;
            case R.id.Ohje:
                Intent Ohje = new Intent(this, Ohje.class);
                startActivity(Ohje);
                return true;
            }
        return true;
    }
/*
    public void showToast(String text) {
        int duration = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
*/

}
