package pagamento;

public class TipoCredito extends FormaPagamento{

    private double taxaRetencao;
    private int prazoPagamento;

    public TipoCredito(int id, String nome, boolean ativo, double taxaRetencao, int prazoPagamento) {
        super(id, nome, ativo);
        this.taxaRetencao = taxaRetencao;
        this.prazoPagamento = prazoPagamento;
    }

    public double getTaxaRetencao() {
        return taxaRetencao;
    }

    public void setTaxaRetencao(double taxaRetencao) {
        this.taxaRetencao = taxaRetencao;
    }

    public int getPrazoPagamento() {
        return prazoPagamento;
    }

    public void setPrazoPagamento(int prazoPagamento) {
        this.prazoPagamento = prazoPagamento;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Tipo: Credito" +
                "\ntaxaRetencao : " + taxaRetencao +
                "\nprazoPagamento : " + prazoPagamento +
                "\n";
    }
}
