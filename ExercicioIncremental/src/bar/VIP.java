package bar;

public class VIP extends Especial {
    private double limite;
    private String gerente;

    public VIP(int id, String nome, int tipo, String endereco, String telefone, String email, char sexo, double limite, String gerente) {
        super(id, nome, tipo, endereco, telefone, email, sexo);
        this.limite = limite;
        this.gerente = gerente;
        super.setCategoria(2);
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLimite: " + limite + "\n Gerente: " + gerente;
    }
}
