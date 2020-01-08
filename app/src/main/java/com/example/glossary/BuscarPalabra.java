package com.example.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glossary.Util.Helper;
import com.example.glossary.Util.Vocabulary;

import java.util.ArrayList;

public class BuscarPalabra extends AppCompatActivity {

    private TextView tv_english, tv_spanish;
    private String english, spanish;
    ArrayList<Vocabulary> listaVocabulary;
    Helper db;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_palabra);

        tv_english = (TextView)findViewById(R.id.tv_EnglishSearch);
        tv_spanish = (TextView)findViewById(R.id.tv_SpanishSearch);

        db = new Helper(getApplicationContext());
        listaVocabulary = db.selectAll();
    }

    //Boton Buscar
    public void BotonBuscar (View view) {
        english = tv_english.getText().toString();
        spanish = tv_spanish.getText().toString();

        for (int i = 0; i < listaVocabulary.size(); i++) {
            if (english.equals(listaVocabulary.get(i).getEnglish())) {
                flag = true;
                Vocabulary registro  = listaVocabulary.get(i);
                Intent intent = new Intent(BuscarPalabra.this, VerPalabra.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("registro", registro);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
        for (int i = 0; i < listaVocabulary.size(); i++) {
            if (spanish.equals(listaVocabulary.get(i).getSpanish())) {
                flag = true;
                Vocabulary registro  = listaVocabulary.get(i);
                Intent intent = new Intent(BuscarPalabra.this, VerPalabra.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("registro", registro);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
        if (!flag){Toast.makeText(this, "No se ha encontrado la palabra..", Toast.LENGTH_SHORT).show();}
    }

    //Boton volver
    public void BotonVolver (View view) {
        finish();
    }
}
