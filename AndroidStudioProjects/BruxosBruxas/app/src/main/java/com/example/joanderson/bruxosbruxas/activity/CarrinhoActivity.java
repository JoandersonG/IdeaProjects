package com.example.joanderson.bruxosbruxas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joanderson.bruxosbruxas.R;
import com.example.joanderson.bruxosbruxas.adapter.AdapterCarrinho;
import com.example.joanderson.bruxosbruxas.model.Carrinho;
import com.example.joanderson.bruxosbruxas.model.Dinheiro;
import com.example.joanderson.bruxosbruxas.model.produto.Livro;
import com.example.joanderson.bruxosbruxas.model.produto.Produto;

public class CarrinhoActivity extends AppCompatActivity {

    //todo: composição
    Carrinho carrinho;
    RecyclerView recyclerView;
    Button botaoComprar;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_carrinho_);

            recyclerView = findViewById(R.id.rvCarrinho);
            total = findViewById(R.id.tvTotal_carrinho);

            if (getIntent().hasExtra("carrinho")) {
                carrinho = (Carrinho) getIntent().getSerializableExtra("carrinho");
                System.out.println("entrou no has extra");
            }

            total.setText(carrinho.getValorTotal().toString());

            AdapterCarrinho adapterCarrinho = new AdapterCarrinho(carrinho);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapterCarrinho);
            botaoComprar = findViewById(R.id.buttonComprar);

            botaoComprar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                    intent.putExtra("carrinho",carrinho);
                    startActivity(intent);
                }
            });
            Livro livro2 = new Livro("Os Contos de Beedle, o Bardo",
                    "Do notável Newt Scamander, um dos maiores bestiários da história de um grande pesquisador de criaturas mágicas.",
                    new Dinheiro(0,10,10),20,R.drawable.livro5,120,"Ficção imfantil");

            if (carrinho.contemProduto(livro2)) {
                System.out.println("contém sim");
            }
            else {
                System.out.println("não contém");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
