package entities;

public class PessoaFisica extends Pessoa {
	
	private double gastosSaude;
	
	public PessoaFisica(String nome, double rendaAnual,double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public PessoaFisica() {
		super();
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	

}
