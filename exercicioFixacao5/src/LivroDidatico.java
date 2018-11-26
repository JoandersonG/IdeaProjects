public class LivroDidatico extends Livro {
    private String area;

    public LivroDidatico(String nome, String editora, double preco, String autorPrincipal, String resumo, String area) {
        super(nome, editora, preco, autorPrincipal, resumo);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() + "\nÁrea: " + area;
    }

    @Override
    public void imprimirNotaFiscal(int quantidade) {
        System.out.println(AplicacaoLivraria.getNomeLivraria());
        System.out.println("Nota Fiscal Eletrônica");
        System.out.println("Preço unitário: " + this.getPreco() + "   Quantidade: " + quantidade);
        System.out.print("Preço total com desconto: ");
        System.out.println(getPreco() - getPreco() * 0.1);
    }
}
