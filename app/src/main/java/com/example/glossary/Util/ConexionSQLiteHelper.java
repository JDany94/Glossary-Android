package com.example.glossary.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context) {
        super(context, Utility.DATA_BASE_NAME, null, Utility.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utility.CREAR_TABLA_VOCABULARY);
        db.execSQL(Utility.CREAR_TABLA_LINKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utility.TABLA_VOCABULARY);
        db.execSQL("DROP TABLE IF EXISTS " + Utility.TABLA_LINKS);
        onCreate(db);
    }

    // Funciones

    public ArrayList<Vocabulary> selectAll () {
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Vocabulary> lista;
        lista = new ArrayList<>();
        Vocabulary registro = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utility.TABLA_VOCABULARY,null);
        while (cursor.moveToNext()) {
            registro = new Vocabulary();
            registro.setId(cursor.getString(0));
            registro.setEnglish(cursor.getString(1));
            registro.setSpanish(cursor.getString(2));
            registro.setDefinition(cursor.getString(3));
            registro.setHyperlink(cursor.getString(4));
            lista.add(registro);
        }
        db.close();
        return lista;
    }

    public void insertarPalabra (String english, String spanish, String definition, String hyperlink) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Utility.CAMPO_ENGLISH, english);
        registro.put(Utility.CAMPO_SPANISH, spanish);
        registro.put(Utility.CAMPO_DEFINITION, definition);
        registro.put(Utility.CAMPO_HYPERLINK, hyperlink);

        Long idResultante = db.insert(Utility.TABLA_VOCABULARY, "null", registro);
        db.close();
    }
}
