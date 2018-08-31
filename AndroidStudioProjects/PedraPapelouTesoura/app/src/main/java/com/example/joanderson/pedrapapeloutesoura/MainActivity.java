package com.example.joanderson.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada(0);
    }
    public void selecionarPapel(View view){
        this.opcaoSelecionada(1);
    }
    public void selecionarTesoura(View view){
        this.opcaoSelecionada(2);
    }
    public void opcaoSelecionada(int escolhaUsuario){

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        switch (numero){
            case 0:
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case 1:
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case 2:
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if((escolhaUsuario == 0 && numero==1) || (escolhaUsuario == 1 && numero==2) || (escolhaUsuario == 2 && numero==0)){
            //se o app é ganhador
            textoResultado.setText("Você Perdeu =(");
        }
        else if((escolhaUsuario == 1 && numero==0) || (escolhaUsuario == 2 && numero==1) || (escolhaUsuario == 0 && numero==2)){
            //jogador venceu
            textoResultado.setText("Você Ganhou =)");
        }
        else{
            //empate
            textoResultado.setText("Empatamos ;D");
        }



    }
}
