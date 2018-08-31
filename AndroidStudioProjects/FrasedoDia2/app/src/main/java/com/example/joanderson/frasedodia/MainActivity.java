package com.example.joanderson.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){
        String[] frases = {
                "Eu sou a essência da magia",
                "Eu sonho e o mundo estremece",
                "Farei você descansar",
                "Eu trago vida e esperança",
                "Eu lamentarei sua morte",
                "Lacaios, serviçais, soldados das trevas gélidas, atendam ao chamado de Kelthuzad",
                "Curvem-se diante do Deus da Morte",
                "É o fim do meu sonho e o início do seu pesadelo",
                "Eu sou Mal'ghanis, eu sou eterno",
                "Eu sou Jaraxxus, Ilidan Lorde da Legião Ardente"
        };
        int num = new Random().nextInt(frases.length);
        TextView texto = (TextView) findViewById(R.id.a_frase);
        texto.setText(frases[num]);

    }

}
