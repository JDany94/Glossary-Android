package com.example.glossary;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glossary.Util.ConexionSQLiteHelper;
import com.example.glossary.Util.Vocabulary;

import android.os.Bundle;
import android.widget.TextView;

public class VerPalabra extends AppCompatActivity {

    private String english, spanish, definition, hyperlink;
    private TextView tv_english, tv_spanish, tv_definition, tv_hyperlink;
    ConexionSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_palabra);

        tv_english = (TextView)findViewById(R.id.tv_English);
        tv_spanish = (TextView)findViewById(R.id.tv_Spanish);
        tv_definition = (TextView)findViewById(R.id.tv_Definition);
        tv_hyperlink = (TextView)findViewById(R.id.tv_HyperLink);

        bd = new ConexionSQLiteHelper(getApplicationContext());

        Bundle registroEnviado = getIntent().getExtras();
        Vocabulary registro = null;

        registro = (Vocabulary) registroEnviado.getSerializable("registro");

        english = registro.getEnglish();
        spanish = registro.getSpanish();
        definition = registro.getDefinition();
        hyperlink = registro.getHyperlink();

        tv_english.setText(english);
        tv_spanish.setText(spanish);
        tv_definition.setText(definition);
        tv_hyperlink.setText(hyperlink);
    }
}
