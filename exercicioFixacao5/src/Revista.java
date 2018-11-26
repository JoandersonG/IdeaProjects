public class Revista extends Titulo {
    private String periodicidade;
    
    public Revista(String nome, String editora, double preco, String periodicidade) {
        super(nome, editora, preco);
        this.periodicidade = periodicidade;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public boolean isEditoraEqual(Revista rev2) {
        return this.getEditora().equals(rev2.getEditora());
    }

    @Override
    public String toString() {
        return super.toString() + "\nPeriodicidade: " + periodicidade;
    }

    @Override
    public void imprimirNotaFiscal(int quantidade) {
        super.imprimirNotaFiscal(quantidade);
        System.out.println(getPreco() - getPreco() * 0.02);
    }
}
