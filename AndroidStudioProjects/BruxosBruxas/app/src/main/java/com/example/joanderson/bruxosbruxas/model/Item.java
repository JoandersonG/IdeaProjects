package com.example.joanderson.bruxosbruxas.model;

import com.example.joanderson.bruxosbruxas.model.produto.Produto;

import java.io.Serializable;

public class Item implements Serializable {
	private Produto produto;
	private int quantidade;
	private Dinheiro valor;

	//todo: sobreposição de construtores
	public Item(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = produto.getPreco();
		this. valor = Dinheiro.multiplicarValor(valor,quantidade);
	}
	
	public Item(Produto produto) {
		this.produto = produto;
		this.quantidade = 1;
		this.valor = produto.getPreco();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Dinheiro getValor() {
		return valor;
	}

	public void setValor(Dinheiro valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return quantidade == item.quantidade &&
				produto.equals(item.produto) &&
				valor.equals(item.valor);
	}
}
