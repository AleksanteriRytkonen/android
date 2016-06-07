package com.example.allu.ostoslista;

/**
 * Created by allu on 7.6.2016.
 */
        import java.util.ArrayList;
        import java.util.List;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteStatement;

public class OmaDbAdapteri {

    private static final String TIETOKANNAN_NIMI = "ostoslista.db";
    private static final String TIETOKANTATAULU = "ostos";
    private static final int TIETOKANNAN_VERSIO = 1;

    // Muuttuja tietokantainstanssille
    private SQLiteDatabase db;
    // Kantaa käyttävän sovelluksen konteksti
    private final Context context;

    private Avaajaavustin avaaja;

    private SQLiteStatement insertlause;
    private static final String INSERT = "insert into " + TIETOKANTATAULU
            + "(OSTOS) values (?)";

    public OmaDbAdapteri(Context context) {
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
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, OSTOS TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int vanhaVersio, int uusiVersio) {
            db.execSQL("DROP TABLE IF EXISTS " + TIETOKANTATAULU);
            onCreate(db);
        }
    }

    public long suoritaInsert(String ostos) {
        this.insertlause.bindString(1, ostos);
        return this.insertlause.executeInsert();
    }

    public void poistaKaikki() {
        this.db.delete(TIETOKANTATAULU, null, null);
    }

    public ArrayList<String> haeKaikki() {
        ArrayList<String> ostoslista = new ArrayList<String>();
        Cursor cursor = this.db.query(TIETOKANTATAULU, new String[] { "ostos" },
                null, null, null, null, "ostos desc");

        if (cursor.moveToFirst()) {
            do {
                ostoslista.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return ostoslista;
    }

}