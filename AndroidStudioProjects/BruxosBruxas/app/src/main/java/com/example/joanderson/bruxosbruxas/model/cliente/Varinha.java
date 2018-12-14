package com.example.joanderson.bruxosbruxas.model.cliente;

public class Varinha {
	private double tamanho;
	private String madeira;
	private String nucleo;
	
	public Varinha(double tamanho, String madeira, String nucleo) {
		this.tamanho = tamanho;
		this.madeira = madeira;
		this.nucleo = nucleo;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public String getMadeira() {
		return madeira;
	}

	public void setMadeira(String madeira) {
		this.madeira = madeira;
	}

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}
	
	
	
	
}
