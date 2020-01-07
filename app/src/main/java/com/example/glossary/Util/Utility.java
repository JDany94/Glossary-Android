package com.example.glossary.Util;

import java.io.Serializable;
import java.util.Calendar;

public class Utility implements Serializable {

    public static final String EVENT_COLOR_NORMAL = "#FD3434";
    public static final String EVENT_COLOR_ESPECIAL = "#FDDC34";
    public static final String DATA_BASE_NAME = "dataBase";
    public static final int VERSION = 1;

    //Constantes de la tabla Vocabulary

    public static final String TABLA_VOCABULARY = "vocabulary";
    public static final String CAMPO_ID_VOCABULARY = "id_vocabulary";
    public static final String CAMPO_ENGLISH = "english";
    public static final String CAMPO_SPANISH = "spanish";
    public static final String CAMPO_DEFINITION = "definition";
    public static final String CAMPO_HYPERLINK = "hyperlink";

    public static final String CREAR_TABLA_VOCABULARY = "CREATE TABLE " + TABLA_VOCABULARY +
            " (" + CAMPO_ID_VOCABULARY + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_ENGLISH + " TEXT, " + CAMPO_SPANISH + " TEXT, " + CAMPO_DEFINITION + " TEXT, " +
            CAMPO_HYPERLINK + " TEXT)";

    //Constantes de la tabla Links

    public static final String TABLA_LINKS = "links";
    public static final String CAMPO_ID_LINKS = "id_links";
    public static final String CAMPO_TITLE = "title";
    public static final String CAMPO_URL = "url";
    public static final String CAMPO_DESCRIPTION = "description";

    public static final String CREAR_TABLA_LINKS = "CREATE TABLE " + TABLA_LINKS +
            " (" + CAMPO_ID_LINKS + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_TITLE + " TEXT, " + CAMPO_URL + " TEXT, " + CAMPO_DESCRIPTION + " TEXT)";


    // Funciones utiles
}

