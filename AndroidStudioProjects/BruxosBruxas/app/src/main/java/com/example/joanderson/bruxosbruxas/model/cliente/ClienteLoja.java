package com.example.joanderson.bruxosbruxas.model.cliente;

import java.io.Serializable;

public class ClienteLoja implements Serializable {
	private String nome;
	private String endereco;
	private Varinha varinha;
	
	public ClienteLoja(String nome, String endereco, Varinha varinha) {
		this.nome = nome;
		this.endereco = endereco;
		this.varinha = varinha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Varinha getVarinha() {
		return varinha;
	}

	public void setVarinha(Varinha varinha) {
		this.varinha = varinha;
	}
	
	
	
	
}
