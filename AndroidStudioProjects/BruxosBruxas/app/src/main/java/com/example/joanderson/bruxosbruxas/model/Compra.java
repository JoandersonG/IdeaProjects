package com.example.joanderson.bruxosbruxas.model;

import com.example.joanderson.bruxosbruxas.model.Carrinho;
import com.example.joanderson.bruxosbruxas.model.cliente.ClienteLoja;

import java.io.Serializable;

public class Compra implements Serializable {
	private Carrinho carrinho;
	private ClienteLoja cliente;
	private boolean isEntregaTrouxa;
	
	public Compra(Carrinho carrinho, ClienteLoja cliente, boolean isEntregaTrouxa) {
		this.carrinho = carrinho;
		this.cliente = cliente;
		this.isEntregaTrouxa = isEntregaTrouxa;
	}

	public ClienteLoja getCliente() {
		return cliente;
	}

	public void setCliente(ClienteLoja cliente) {
		this.cliente = cliente;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public boolean isEntregaTrouxa() {
		return isEntregaTrouxa;
	}

	public void setEntregaTrouxa(boolean entregaTrouxa) {
		isEntregaTrouxa = entregaTrouxa;
	}
}
