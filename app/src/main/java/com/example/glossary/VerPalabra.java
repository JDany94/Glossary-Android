package com.example.glossary;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glossary.Util.Vocabulary;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VerPalabra extends AppCompatActivity {

    private String english, spanish, definition, hyperlink;
    private TextView tv_english, tv_spanish, tv_definition, tv_hyperlink;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_palabra);

        tv_english = (TextView)findViewById(R.id.tv_English);
        tv_spanish = (TextView)findViewById(R.id.tv_Spanish);
        tv_definition = (TextView)findViewById(R.id.tv_Definition);
        tv_hyperlink = (TextView)findViewById(R.id.tv_HyperLink);

        Bundle registroEnviado = getIntent().getExtras();
        Vocabulary registro = null;

        registro = (Vocabulary) registroEnviado.getSerializable("registro");

        tv_english.setText("-");
        tv_spanish.setText("-");
        tv_definition.setText("-");
        tv_hyperlink.setText("-");

        english = registro.getEnglish();
        spanish = registro.getSpanish();
        definition = registro.getDefinition();
        hyperlink = registro.getHyperlink();

        tv_english.setText(english);
        tv_spanish.setText(spanish);
        tv_definition.setText(definition);
        tv_hyperlink.setText(hyperlink);
    }

    //Boton volver
    public void BotonVolver (View view) {
        finish();
    }
}
