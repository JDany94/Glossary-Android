package com.example.glossary.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Helper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

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

    public ArrayList<Links> selectAllLinks () {
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Links> lista;
        lista = new ArrayList<>();
        Links registro = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utility.TABLA_LINKS,null);
        while (cursor.moveToNext()) {
            registro = new Links();
            registro.setId(cursor.getString(0));
            registro.setTitle(cursor.getString(1));
            registro.setUrl(cursor.getString(2));
            registro.setDescription(cursor.getString(3));
            lista.add(registro);
        }
        db.close();
        return lista;
    }
}
