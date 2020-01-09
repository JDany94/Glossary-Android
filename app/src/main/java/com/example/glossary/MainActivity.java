package com.example.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Boton Diccionario
    public void BotonDiccionario (View view) {
        Intent verDiccionario = new Intent(this, Diccionario.class);
        startActivity(verDiccionario);
    }

    //Boton Agregar
    public void BotonAgregar (View view) {
        Intent agregar = new Intent(this, AgregarPalabra.class);
        startActivity(agregar);
    }

    //Boton Buscar
    public void BotonBuscar (View view) {
        Intent buscar = new Intent(this, BuscarPalabra.class);
        startActivity(buscar);
    }

    //Boton Links
    public void BotonLinks (View view) {
        Intent link = new Intent(this, VerLinks.class);
        startActivity(link);
    }

    //Boton Info
    public void BotonInfo (View view) {
        Intent info = new Intent(this, VerInfo.class);
        startActivity(info);
    }

    //Boton volver
    public void BotonVolver (View view) {
        finish();
    }
}
