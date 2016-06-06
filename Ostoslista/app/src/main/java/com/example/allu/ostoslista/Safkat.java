package com.example.allu.ostoslista;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by allu on 6.6.2016.
 */
public class Safkat {
    private ArrayList<String> ruokalista;

    public Safkat() {
        this.ruokalista = new ArrayList<>();
    }

    public void lisaa(String ruoka) {
        if(ruoka != null || ruoka != "") {
            ruokalista.add(ruoka);
        }
    }

    public ArrayList<String> getRuokalista() {
        return ruokalista;
    }

    public void setRuokalista(ArrayList<String> ruokalista) {
        this.ruokalista = ruokalista;
    }
}
