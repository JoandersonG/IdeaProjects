package com.example.joanderson.bruxosbruxas.model.pagamento;

import com.example.joanderson.bruxosbruxas.model.Dinheiro;
import com.example.joanderson.bruxosbruxas.model.cliente.ClienteLoja;

import java.util.ArrayList;

//todo: consertar imports

public class Autorizacao {
	private static ArrayList<ClienteBanco> contasGringotes = new ArrayList<>();
	//private Pagamento pagamento;
	
	public static void addCliente(ClienteBanco cliente) {
		contasGringotes.add(cliente);
	}
	
	public static void removeCliente(ClienteBanco cliente) {
		contasGringotes.remove(cliente);
	}

	public static ArrayList<ClienteBanco> getContasGringotes() {
		return contasGringotes;
	}

	/*
	public boolean verificaCliente() {
		boolean autorizado = false;
		ClienteLoja clienteLoja = pagamento.getCompra().getCliente();
		double valorCompra = pagamento.getCompra().getCarrinho().getValorTotal();
		for(int i = 0; i < contasGringotes.size(); i++) {
			ClienteBanco cliente = contasGringotes.get(i);
			if(clienteLoja.getNome().equals(cliente.getNome())) {
				if(cliente.getSaldoConta() >= valorCompra) {
					autorizado = true;
				}else {
					autorizado = false;
				}
			}
		}
		return autorizado;
	}
	*/

	public static boolean autorizaPagamento(Pagamento pagamento) {
		boolean autorizado = false;
		for (ClienteBanco c : contasGringotes) {
			if (c.getNome().equals(pagamento.getCompra().getCliente().getNome()) &&
					c.getVarinha() == pagamento.getCompra().getCliente().getVarinha()) {
				//encontrei o cliente
				if (c.getSaldoConta().isMaiorQue(pagamento.getCompra().getCarrinho().getValorTotal())) {
					autorizado = true;
				}
				break;
			}
		}
		return autorizado;
	}

	public static void debitarConta(Pagamento pagamento) {
		Dinheiro valor = pagamento.getCompra().getCarrinho().getValorTotal();
		for (ClienteBanco c : contasGringotes) {
			if (c.getNome().equals(pagamento.getCompra().getCliente().getNome()) &&
					c.getVarinha() == pagamento.getCompra().getCliente().getVarinha()) {
				//encontrei o cliente
				c.getSaldoConta().subtrairValor(valor);
			}
		}
	}




	
	
	
	

	
	
}
