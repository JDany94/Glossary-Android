package com.example.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.glossary.Util.Links;
import com.example.glossary.Util.Vocabulary;

public class ViewLink extends AppCompatActivity {

    private String title, url, description;
    private TextView tv_title, tv_url, tv_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_link);

        tv_title = (TextView)findViewById(R.id.tv_Title);
        tv_url = (TextView)findViewById(R.id.tv_Url);
        tv_description = (TextView)findViewById(R.id.tv_Description);

        Bundle registroEnviado = getIntent().getExtras();
        Links registro = null;

        registro = (Links) registroEnviado.getSerializable("registro");

        tv_title.setText("-");
        tv_url.setText("-");
        tv_description.setText("-");

        tv_title.setText(registro.getTitle());
        tv_url.setText(registro.getUrl());
        tv_description.setText(registro.getDescription());
    }

    //Boton volver
    public void BotonVolver (View view) {
        finish();
    }
}
