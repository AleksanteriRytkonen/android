package com.example.allu.ostoslista;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by allu on 6.6.2016.
 */
public class DatabaseManager {
    private SQLiteDatabase db;
    private static final String DB_NAME = "Ostoslista";

    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "ostoslista_table";
    private static final String TABLE_ROW_ID = "_id";
    private static final String TABLE_RUOKA_NIMI = "ruoka_nimi";
}
