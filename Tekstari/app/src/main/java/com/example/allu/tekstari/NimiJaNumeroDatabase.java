package com.example.allu.tekstari;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class NimiJaNumeroDatabase {

    private static final String TIETOKANNAN_NIMI = "niminumero.db";
    private static final String TIETOKANTATAULU = "nimijanumero";
    private static final int TIETOKANNAN_VERSIO = 1;

    // Muuttuja tietokantainstanssille
    private SQLiteDatabase db;
    // Kantaa käyttävän sovelluksen konteksti
    private final Context context;

    private Avaajaavustin avaaja;

    private SQLiteStatement insertlause;
    private static final String INSERT = "insert into " + TIETOKANTATAULU + "(NIMI, NUMERO) values(?, ?)";

    public NimiJaNumeroDatabase(Context context) {
        this.context = context;
        avaaja = new Avaajaavustin(this.context);
        luoKantayhteys();
        this.insertlause = this.db.compileStatement(INSERT);
    }

    private void luoKantayhteys() {
        if(db==null) {
            db = avaaja.getWritableDatabase();
        }
    }

    public void puraKantayhteys() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    /*
     * Sisäluokka Avaajaavustin periytyy SQLiteOpenHelperistä. Luokka luo tai
     * päivittää tietokannan automaattisesti versionumeroon perustuen.
     */
    private static class Avaajaavustin extends SQLiteOpenHelper {

        Avaajaavustin(Context context) {
            super(context, TIETOKANNAN_NIMI, null, TIETOKANNAN_VERSIO);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TIETOKANTATAULU
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, NIMI TEXT, NUMERO TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int vanhaVersio, int uusiVersio) {
            db.execSQL("DROP TABLE IF EXISTS " + TIETOKANTATAULU);
            onCreate(db);
        }
    }

    public long suoritaInsert(String nimi, String numero) {
        this.insertlause.bindString(1, nimi);
        this.insertlause.bindString(2, numero);
        return this.insertlause.executeInsert();
    }

    public void poistaKaikki() {
        this.db.delete(TIETOKANTATAULU, null, null);
    }
/*TEE TOINEN HAKULAUSE PELKKIÄ NUMEROITA VARTEN, JOTTA ITSE TEKSTARIT VOIDAAN LÄHETTÄÄ. */

    public ArrayList<String> haeNumerot() {
        ArrayList<String> numerot = new ArrayList<>();
        Cursor cursor = this.db.query(TIETOKANTATAULU, new String[] { "numero" }, null, null, null, null, "nimi desc");
        if(cursor.moveToFirst()) {
            do {
                numerot.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return numerot;
    }

    public ArrayList<String> haeKaikki() {
        ArrayList<String> nimetJaNumerot = new ArrayList<String>();
        Cursor cursor = this.db.query(TIETOKANTATAULU, new String[] { "nimi", "numero" },
                null, null, null, null, "nimi desc");

        if (cursor.moveToFirst()) {
            do {
                nimetJaNumerot.add(cursor.getString(0) + " " + cursor.getString(1));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return nimetJaNumerot;
    }

}