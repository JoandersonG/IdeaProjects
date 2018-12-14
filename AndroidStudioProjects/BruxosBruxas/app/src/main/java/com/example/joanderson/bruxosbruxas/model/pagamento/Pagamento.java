package com.example.joanderson.bruxosbruxas.model.pagamento;
import com.example.joanderson.bruxosbruxas.model.Compra;


public class Pagamento {
	private Compra compra;
	//private Autorizacao auto = new Autorizacao();

	public Pagamento(Compra compra) {
		this.compra = compra;
	}

	public Compra getCompra() {
		return compra;
	}
	
	public boolean efetuaPagamento() {
		boolean teste = false;

		if (Autorizacao.autorizaPagamento(this)) {
			teste = true;
			Autorizacao.debitarConta(this);
		}

		return teste;
	}

	
	
	
	
	
}
