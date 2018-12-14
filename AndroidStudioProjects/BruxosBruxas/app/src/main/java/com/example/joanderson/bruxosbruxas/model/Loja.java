package com.example.joanderson.bruxosbruxas.model;

import com.example.joanderson.bruxosbruxas.model.produto.Produto;

import java.io.Serializable;
import java.util.ArrayList;

public class Loja implements Serializable {
    Carrinho carrinho;
    ArrayList <Produto> produtos;

    public Loja() {
        this.carrinho = new Carrinho();
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void adicionarAoCarrinho(Produto produto, int quantidade) {
        if(carrinho.contemProduto(produto)) {
            carrinho.adicionarMaisDoProduto(produto,1);
        }
        else {
            carrinho.addItem(new Item(produto,quantidade));
        }
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
