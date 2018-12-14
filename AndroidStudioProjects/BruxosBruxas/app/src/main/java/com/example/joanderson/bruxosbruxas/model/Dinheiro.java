package com.example.joanderson.bruxosbruxas.model;

import java.io.Serializable;

public class Dinheiro implements Serializable {
	private int galeao;
	private int sicle;
	private int nuque;
	
	public Dinheiro(int galeao, int sicle, int nuque) {
		this.galeao = galeao;
		this.sicle = sicle;
		this.nuque = nuque;
	}

	public int getGaleao() {
		return galeao;
	}

	public void setGaleao(int galeao) {
		this.galeao = galeao;
	}

	public int getSicle() {
		return sicle;
	}

	public void setSicle(int sicle) {
		this.sicle = sicle;
	}

	public int getNuque() {
		return nuque;
	}

	public void setNuque(int nuque) {
		this.nuque = nuque;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dinheiro preco = (Dinheiro) o;
		return galeao == preco.galeao &&
				sicle == preco.sicle &&
				nuque == preco.nuque;
	}

	//todo: sobrposição
	@Override
	public String toString() {
		String preco = "";

		if (galeao != 0) {
			if (galeao > 1) {
				preco += galeao + " galeões";
			}
			else {
				preco += galeao + " galeão";
			}
			if (sicle != 0 || nuque != 0) {
				preco += ", ";
			}
		}
		if (sicle != 0) {
			if (sicle > 1) {
				preco += sicle + " sicles";
			}
			else {
				preco += sicle + " sicle";
			}
			if (nuque != 0) {
				preco += ", ";
			}
		}
		if (nuque != 0) {
			if (nuque > 1) {
				preco += nuque + " nuques";
			}
			else {
				preco += nuque + " nuque";
			}

		}
		return preco;
	}

	public void subtrairValor(Dinheiro preco) {
		this.nuque -= preco.nuque;
		this.sicle -= preco.sicle;
		this.galeao -= preco.galeao;
	}

	public void adicionarValor(Dinheiro preco) {
		while (preco.nuque >= 29) {
			preco.sicle++;
			preco.nuque -= 29;
		}
		while (preco.sicle >= 17) {
			preco.sicle -= 17;
			preco.galeao++;
		}
		this.nuque += preco.nuque;
		this.sicle += preco.sicle;
		this.galeao += preco.galeao;
	}

	//todo: método estático
	public static Dinheiro multiplicarValor(Dinheiro preco, int multiplicador) {
		if (preco == null) return null;
		if (preco.nuque != 0) {
			preco.nuque = preco.nuque * multiplicador;
		}

		if (preco.sicle != 0) {
			preco.sicle = preco.sicle * multiplicador;
		}

		if (preco.galeao != 0) {
			preco.galeao *= multiplicador;
		}
		while (preco.nuque >= 29) {
			preco.sicle++;
			preco.nuque -= 29;
		}
		while (preco.sicle >= 17) {
			preco.sicle -= 17;
			preco.galeao++;
		}
		return preco;
	}

	public boolean isMaiorQue(Dinheiro valor2) {
		boolean teste = false;

		if (valor2.getGaleao() < this.getGaleao()) {
			teste = true;
		}
		else if (valor2.getGaleao() == this.galeao && valor2.getSicle() < this.sicle) {
			teste = true;
		}
		else if (valor2.getGaleao() == this.galeao && valor2.getSicle() == this.sicle && valor2.getNuque() < this.nuque) {
			teste = true;
		}
		else{
			teste = false;
		}

		return teste;
	}
}
