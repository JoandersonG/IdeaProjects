
public class Produto {
	private String nome;
	private int codigo;
	private double precoUnitario;
	public Produto(String nome, int codigo, double precoUnitario) {
		this.nome = nome;
		this.codigo = codigo;
		this.precoUnitario = precoUnitario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	
	
}
