package com.example.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.glossary.Util.Helper;
import com.example.glossary.Util.Links;
import com.example.glossary.Util.Vocabulary;

import java.util.ArrayList;

public class VerLinks extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listaInformacion_lv;
    ArrayList<Links> listaLinks;
    Helper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_links);

        db = new Helper(getApplicationContext());

        listaLinks = db.selectAllLinks(); // Se carga la lista con la base de datos

        listView = (ListView)findViewById(R.id.lv_VerLinks);
        cargarLista();

        ArrayAdapter adaptador = new ArrayAdapter(this, R.layout.listview_item, listaInformacion_lv);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Links registro  = listaLinks.get(position);

                Intent intent = new Intent(VerLinks.this, ViewLink.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("registro", registro);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void cargarLista() {
        listaInformacion_lv = new ArrayList<String>();
        for (int i = 0; i < listaLinks.size(); i++) {
            listaInformacion_lv.add(listaLinks.get(i).getTitle());
        }
    }

    //Boton volver
    public void BotonVolver (View view) {
        finish();
    }
}
