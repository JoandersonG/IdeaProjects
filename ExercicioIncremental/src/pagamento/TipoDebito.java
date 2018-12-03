package pagamento;

public class TipoDebito extends FormaPagamento {

    private double taxaRetencao;
    private String contaCorrente;

    public TipoDebito(int id, String nome, boolean ativo, double taxaRetencao, String contaCorrente) {
        super(id, nome, ativo);
        this.taxaRetencao = taxaRetencao;
        this.contaCorrente = contaCorrente;
    }

    public double getTaxaRetencao() {
        return taxaRetencao;
    }

    public void setTaxaRetencao(double taxaRetencao) {
        this.taxaRetencao = taxaRetencao;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Tipo: Debito" +
                "\ntaxaRetencao :" + taxaRetencao +
                "\n contaCorrente :" + contaCorrente +
                "\n";
    }
}

