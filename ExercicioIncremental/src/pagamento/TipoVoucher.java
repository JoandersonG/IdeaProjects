package pagamento;

public class TipoVoucher extends FormaPagamento{

    private double diaria;
    private int prazoPagamento;
    private String contaCorrente;

    public TipoVoucher(int id, String nome, boolean ativo, double diaria, int prazoPagamento, String contaCorrente) {
        super(id, nome, ativo);
        this.diaria = diaria;
        this.prazoPagamento = prazoPagamento;
        this.contaCorrente = contaCorrente;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public int getPrazoPagamento() {
        return prazoPagamento;
    }

    public void setPrazoPagamento(int prazoPagamento) {
        this.prazoPagamento = prazoPagamento;
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
                "Tipo: Voucher" +
                "\ndiaria : " + diaria +
                "\nprazoPagamento : " + prazoPagamento +
                "\ncontaCorrente : " + contaCorrente +
                "\n";
    }
}
