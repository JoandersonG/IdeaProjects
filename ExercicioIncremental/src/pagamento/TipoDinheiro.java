package pagamento;

public class TipoDinheiro extends FormaPagamento{

    private int forma;

    public TipoDinheiro(int id, String nome, boolean ativo, int forma) {
        super(id, nome, ativo);
        if ((forma >= 0 && forma <= 4) || forma == 9) {
            this.forma = forma;
        }
        else{
            System.out.print("Valor de id inválido.");
        }
    }

    public int getForma() {
        return forma;
    }

    public void setForma(int forma) {
        this.forma = forma;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Tipo: Dinheiro" +
                "\nforma: " + forma +
                "\n";
    }
}
