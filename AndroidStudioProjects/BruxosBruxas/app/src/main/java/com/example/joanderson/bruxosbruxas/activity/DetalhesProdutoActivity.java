package com.example.joanderson.bruxosbruxas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joanderson.bruxosbruxas.R;
import com.example.joanderson.bruxosbruxas.model.Carrinho;
import com.example.joanderson.bruxosbruxas.model.Item;
import com.example.joanderson.bruxosbruxas.model.produto.Livro;
import com.example.joanderson.bruxosbruxas.model.Loja;
import com.example.joanderson.bruxosbruxas.model.produto.Pocao;
import com.example.joanderson.bruxosbruxas.model.produto.Produto;
import com.example.joanderson.bruxosbruxas.model.produto.Utensilio;
import com.example.joanderson.bruxosbruxas.model.produto.Vestimenta;


public class DetalhesProdutoActivity extends AppCompatActivity {

    ImageView ivProduto;
    TextView titulo, detalhes, preco;
    Produto produto;
    Button botaoAddCarrinho;
    Carrinho carrinho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);

        ivProduto = findViewById(R.id.iv_produto_detalhes);
        titulo = findViewById(R.id.tvTitulo_detalhes);
        detalhes = findViewById(R.id.tvDetalhes_detalhes);
        preco = findViewById(R.id.tvPreco_detalhes);
        botaoAddCarrinho = findViewById(R.id.buttonAddCarrinho_detalhes);

        if (getIntent().hasExtra("produto")) {

            produto = (Produto) getIntent().getSerializableExtra("produto");

            ivProduto.setImageResource(produto.getImagem());
            titulo.setText(produto.getNome());
            detalhes.setText(descricaoCompleta(produto));

            String p = preco.getText().toString() + produto.getPreco().toString();
            preco.setText(p);
        }
        if (getIntent().hasExtra("carrinho")) {
            carrinho = (Carrinho) getIntent().getSerializableExtra("carrinho");
        }

        botaoAddCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carrinho != null) {
                    Toast.makeText(getApplicationContext(), produto.getNome() +
                            " adicionado ao carrinho",Toast.LENGTH_SHORT).show();

                    carrinho.addItem(new Item(produto));
                    //loja.adicionarAoCarrinho(produto,1);
                }
            }
        });


    }

    public String descricaoCompleta(Produto produto) {
        String desc = produto.getDescricao();
        //todo: cast e instance of
        if (produto instanceof Livro) {
            Livro livro = (Livro) produto;
            desc += "\nGênero: " + livro.getGenero() +
                    "\nQuantidade de páginas: " + String.valueOf(livro.getQtdPaginas());
        }
        else if (produto instanceof Pocao) {
            Pocao pocao = (Pocao) produto;
            desc += "\nContra indicações: " + pocao.getContraIndicacao() +
                    "\nEfeitos colaterais: " + pocao.getEfeitoColateral();
        }
        else if (produto instanceof Utensilio) {
            Utensilio utensilio = (Utensilio) produto;
            desc += "\nCategoria: " + utensilio.getCategoria();
        }
        else if (produto instanceof Vestimenta) {
            Vestimenta vestimenta = (Vestimenta) produto;
            desc += "\nCategoria: " + vestimenta.getCategoria() + "\nTamanho: " + vestimenta.getTamanho();
        }
        else {
            throw new ClassCastException();
        }

        return desc;
    }
}
