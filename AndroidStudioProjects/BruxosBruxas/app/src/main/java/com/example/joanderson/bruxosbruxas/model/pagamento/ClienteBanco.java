package com.example.joanderson.bruxosbruxas.model.pagamento;

import com.example.joanderson.bruxosbruxas.model.Dinheiro;
import com.example.joanderson.bruxosbruxas.model.cliente.Varinha;

public class ClienteBanco {
	private String nome;
	private Dinheiro saldoConta;
	private Varinha varinha;
	
	public ClienteBanco(String nome, Dinheiro saldoConta, Varinha varinha) {
		this.nome = nome;
		this.saldoConta = saldoConta;
		this.varinha = varinha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Dinheiro getSaldoConta() {
		return saldoConta;
	}
	
	public void setSaldoConta(Dinheiro saldoConta) {
		this.saldoConta = saldoConta;
	}

	public Varinha getVarinha() {
		return varinha;
	}

	public void setVarinha(Varinha varinha) {
		this.varinha = varinha;
	}
}
