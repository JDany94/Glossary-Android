package com.example.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glossary.Util.Vocabulary;

import com.example.glossary.Util.ConexionSQLiteHelper;

import java.util.ArrayList;

public class AgregarPalabra extends AppCompatActivity {

    private TextView tv_english, tv_spanish, tv_definition, tv_hyperlink;
    private String english, spanish, definition, hyperlink;
    ArrayList<Vocabulary> listaVocabulary;
    ConexionSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_palabra);

        tv_english = (TextView)findViewById(R.id.tv_EnglishADD);
        tv_spanish = (TextView)findViewById(R.id.tv_SpanishADD);
        tv_definition = (TextView)findViewById(R.id.tv_DefinitionADD);
        tv_hyperlink = (TextView)findViewById(R.id.tv_HyperLinkADD);


        bd = new ConexionSQLiteHelper(getApplicationContext());
        listaVocabulary = bd.selectAll();
    }

    //Boton para guardar
    public void BotonGuardar (View view) {
        String english = tv_english.getText().toString();
        String spanish = tv_spanish.getText().toString();
        if (english.equals("") || spanish.equals("")) {
            Toast.makeText(this, "Falta llenar algunos campos..", Toast.LENGTH_SHORT).show();
        } else {
            bd.insertarPalabra(tv_english.getText().toString(), tv_spanish.getText().toString(), tv_definition.getText().toString(), tv_hyperlink.getText().toString());
            Toast.makeText(this, "Palabra Guardada", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //Boton volver
    public void BotonVolver (View view) {
        finish();
    }
}
