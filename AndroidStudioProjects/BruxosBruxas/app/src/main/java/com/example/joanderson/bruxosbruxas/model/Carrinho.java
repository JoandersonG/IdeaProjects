package com.example.joanderson.bruxosbruxas.model;

import com.example.joanderson.bruxosbruxas.model.produto.Produto;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrinho implements Serializable {
	private ArrayList<Item> itens;
	private Dinheiro valorTotal;

	public Carrinho() {
		itens = new ArrayList<>();
		valorTotal = new Dinheiro(0,0,0);
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void addItem(Item item) {
		/*if(item.getProduto().getEstoque() > 0) {
			this.itens.add(item);
			this.valorTotal.adicionarValor(item.getValor());
		}*/
		System.out.println("Adicionado item " + item.getProduto().getNome());
		itens.add(item);
		this.valorTotal.adicionarValor(item.getValor());
	}
	
	public void excluirItem(Item item) { // pode ser uma sobrecarga aqui com remover - esse metodo remove todos
		/*for(int i = 0; i < this.itens.size(); i++) {
			Item it = this.itens.get(i);
			if(item == it) {
				this.itens.remove(it);
			}
		}*/
		/*for (Item i : itens) {
			if (i.equals(item)) {
				itens.remove(i);
			}
		}*/
		this.itens.remove(item);
		this.valorTotal.subtrairValor(item.getValor());//todo: criar em Dinheiro um método subtrairValor();


	}
	
	public void removerItem(Item item) {// tira um por um
		for(int i = 0; i < this.itens.size(); i++) {
			Item it = this.itens.get(i);
			if(item == it) {//isso não funciona assim
				it.setQuantidade(it.getQuantidade()-1);
			}
		}
	}
	
	public Dinheiro getValorTotal() {
		int sumG = 0;
		int sumN = 0;
		int sumS = 0;
		Item it;
		for(int i = 0; i < this.itens.size(); i++) {
			it = this.itens.get(i);
			sumG += it.getValor().getGaleao();
			sumS += it.getValor().getSicle();
			sumN += it.getValor().getNuque();
			
		}
		this.valorTotal = new Dinheiro(sumG, sumS, sumN);

		return this.valorTotal;
	}

	public boolean contemProduto(Produto produto) {
		boolean teste = false;
		for (Item i : itens) {
			if (i.getProduto().equals(produto)) {
				teste = true;
			}
		}
		return teste;
	}

	public void adicionarMaisDoProduto(Produto produto, int qtd) {
		for (Item i : itens) {
			if (i.getProduto().equals(produto)) {
				i.setQuantidade(i.getQuantidade() + qtd);
			}
		}
	}




}
