package com.example.joanderson.bruxosbruxas.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.joanderson.bruxosbruxas.R;
import com.example.joanderson.bruxosbruxas.adapter.AdapterProduto;
import com.example.joanderson.bruxosbruxas.model.produto.Livro;
import com.example.joanderson.bruxosbruxas.model.Loja;
import com.example.joanderson.bruxosbruxas.model.Dinheiro;
import com.example.joanderson.bruxosbruxas.model.produto.Utensilio;
import com.example.joanderson.bruxosbruxas.model.produto.Vestimenta;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerProduto;
    private ImageView ivCarrinho;
    private FloatingActionButton fab;
    private Loja loja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);





            //todo: try e catch


            recyclerProduto = findViewById(R.id.rvProdutos);
            fab = findViewById(R. id.fabCarrinho);
            loja = new Loja();


            adicionarProdutos();


            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
                    intent.putExtra("carrinho", loja.getCarrinho());
                    if (loja.getCarrinho() == null)
                        System.out.println("MainActivity nao colocou o carrinho como extra");
                    startActivity(intent);
                }
            });
            /*ivCarrinho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent  intent = new Intent(this,CarrinhoActivity.class);

                    Intent intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
                    intent.putExtra("carrinho", loja.getCarrinho());
                    if (loja.getCarrinho() == null)
                        System.out.println("MainActivity nao colocou o carrinho como extra");
                    startActivity(intent);

                }
            });*/

            //definir layout
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
            recyclerProduto.setLayoutManager(layoutManager);

            //definir adapter
            AdapterProduto adapter = new AdapterProduto(this, loja);
            recyclerProduto.setAdapter(adapter);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adicionarProdutos() {
        try {

            Vestimenta chapeu1 = new Vestimenta("Chapéu Pomodora",
                    "Chapéu encantado que cobre seu rosto de pessoas indesejáveis.",
                    new Dinheiro(1, 2, 3), 10, R.drawable.chapeu_1, "chapéu",'u');

            Utensilio caldeirao1 = new Utensilio("Caldeirão de Estanho",
                    "Caldeirão de fundo grosso, perfeitamente capaz.",
                    new Dinheiro(0, 10, 0), 20, R.drawable.caldeirao_um, "escolar");

            Livro livro1 = new Livro("Animais Fantáticos e Onde Habitam",
                    "Do notável Newt Scamander, um dos maiores bestiários da história de um grande pesquisador de criaturas mágicas.",
                    new Dinheiro(0,20,0),20,R.drawable.livro4,340,"Não-Ficção");

            Livro livro2 = new Livro("Os Contos de Beedle, o Bardo",
                    "Do notável Newt Scamander, um dos maiores bestiários da história de um grande pesquisador de criaturas mágicas.",
                    new Dinheiro(0,10,10),20,R.drawable.livro5,120,"Ficção imfantil");

            Livro livro3 = new Livro("Advanced Potion Making",
                    "Do notável Newt Scamander, um dos maiores bestiários da história de um grande pesquisador de criaturas mágicas.",
                    new Dinheiro(0,20,0),20,R.drawable.livro6,360,"Não-Ficção");

            Vestimenta vestido1 = new Vestimenta("Vestido Estrelado",
                    "",
                    new Dinheiro(0,20,5),5,R.drawable.vestido1,"Vestido",'m');

            Vestimenta roupaInfantil = new Vestimenta("Veste Infantil para Festas",
                    "",
                    new Dinheiro(1,0,0),5,R.drawable.infantil,"Infantil",'p');


            //todo: polimorfismo|| loja.adicionarProduto() recebe um Produto
            loja.adicionarProduto(chapeu1);
            loja.adicionarProduto(caldeirao1);
            loja.adicionarProduto(livro1);
            loja.adicionarProduto(livro2);
            loja.adicionarProduto(livro3);
            loja.adicionarProduto(vestido1);
            loja.adicionarProduto(roupaInfantil);

            //loja.adicionarAoCarrinho(caldeirao1,2);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
