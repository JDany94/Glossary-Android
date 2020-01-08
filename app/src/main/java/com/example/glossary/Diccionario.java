package com.example.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.glossary.Util.Vocabulary;

import com.example.glossary.Util.ConexionSQLiteHelper;

import java.util.ArrayList;

public class Diccionario extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listaInformacion_lv;
    ArrayList<Vocabulary> listaVocabulary;
    ConexionSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diccionario);

        bd = new ConexionSQLiteHelper(getApplicationContext());
        listaVocabulary = bd.selectAll(); // Se carga la lista con la base de datos

        listView = (ListView)findViewById(R.id.lv_VerDicc);
        cargarLista();

        ArrayAdapter adaptador = new ArrayAdapter(this, R.layout.listview_item, listaInformacion_lv);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Vocabulary registro  = listaVocabulary.get(position);

                Intent intent = new Intent(Diccionario.this, VerPalabra.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("registro", registro);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void cargarLista() {
        listaInformacion_lv = new ArrayList<String>();
        for (int i = 0; i < listaVocabulary.size(); i++) {
            listaInformacion_lv.add(listaVocabulary.get(i).getEnglish());
        }
    }

    //Boton volver
    public void BotonVolver (View view) {
        finish();
    }
}
