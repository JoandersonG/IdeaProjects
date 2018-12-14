package com.example.joanderson.bruxosbruxas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joanderson.bruxosbruxas.R;

import static android.system.Os.close;

public class CompraConcluidaActivity extends AppCompatActivity {

    TextView tvStatusPedido, tvDescricao;
    Button buttonVoltarLoja;
    boolean statusCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_concluida);

        tvStatusPedido = findViewById(R.id.tvCompraStatus);
        tvDescricao = findViewById(R.id.tvTextoApoio);
        buttonVoltarLoja = findViewById(R.id.buttonVoltarLoja);

        statusCompra = getIntent().getBooleanExtra("statusPagamento",true);
        //todo: exception
        if (statusCompra){
            setCompraRealizada();
        }
        else {
            setCompraNaoRealizada();
        }



        buttonVoltarLoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (statusCompra) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    finish();
                }

            }
        });


    }

    public void setCompraRealizada() {
        String mainTexto = "COMPRA REALIZADA COM SUCESSO";
        tvStatusPedido.setText(mainTexto);
        String comp = " Em até dois dias sua compra chegará em sua casa." +
                "\nAproveite e continue comprando";
        tvDescricao.setText(comp);
    }

    public void setCompraNaoRealizada() {
        String mainTexto = "COMPRA NÃO REALIZADA";
        tvStatusPedido.setText(mainTexto);
        String comp = "Houve algum problema com suas informações ou seu saldo no Gringotes é insuficiente.";
        tvDescricao.setText(comp);

        buttonVoltarLoja.setText("   Tentar novamente   ");
    }
}
