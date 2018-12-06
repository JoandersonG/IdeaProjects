package com.example.joanderson.bruxosbruxas.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joanderson.bruxosbruxas.R;

public class Login_Activity extends AppCompatActivity {

    private EditText nome,endereco,contaBanco,tamanhoVarinha,nucleoVarinha,madeiraVarinha;
    private Button buttonComprar,buttonCancelar;
    private Switch entregaTrouxa;
    private TextView valorCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        nome = findViewById(R.id.etNome);
        endereco = findViewById(R.id.etEndereco);
        entregaTrouxa = findViewById(R.id.switchTrouxas);
        contaBanco = findViewById(R.id.etBanco);
        tamanhoVarinha = findViewById(R.id.etTamanho);
        nucleoVarinha = findViewById(R.id.etNucleo);
        madeiraVarinha = findViewById(R.id.etMadeira);
        buttonComprar = findViewById(R.id.btComprar);
        buttonCancelar = findViewById(R.id.btCancelar);
        valorCompra = findViewById(R.id.tvValorFinal);


        }

        public void comprar(View view) {
            Intent intent = new Intent(getApplicationContext(),CarrinhoActivity.class);
            startActivity(intent);
          /*  if (testeComprar()) {
                //todo: efetua a compra
            }
            else {
                Toast.makeText(this,"Por favor, preencha todos os campos", Toast.LENGTH_LONG).show();

            }*/



        // TODO: testar se quando clicar no botão comprar os valores são válidos

        }

        public boolean testeComprar() {
            boolean teste = true;
            if (nome.getText().toString().equals("")
                    || endereco.getText().toString().equals("")
                    || contaBanco.getText().toString().equals("")
                    || tamanhoVarinha.getText().toString().equals("")
                    || nucleoVarinha.getText().toString().equals("")
                    || madeiraVarinha.getText().toString().equals("")
                    ) {
                teste = false;
            }
            return teste;
        }

        public void leituraEt(View view) {
            ((EditText)view).setHint("");
            ((EditText)view).setTextColor(Color.rgb(0,0,0));

        }

}