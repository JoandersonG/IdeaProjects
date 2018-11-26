public class Titulo {
    private String nome;
    private String editora;
    private double preco;

    public Titulo(String nome, String editora, double preco) {
        this.nome = nome;
        this.editora = editora;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nEditora: " + editora + "\nPreço: " + preco;
    }

    public void imprimirNotaFiscal(int quantidade) {
        System.out.println(AplicacaoLivraria.getNomeLivraria());
        System.out.println("Nota Fiscal Eletrônica");
        System.out.println("Preço unitário: " + preco + "   Quantidade: " + quantidade);
        System.out.print("Preço total com desconto: ");
    }
    
}
