public class Livro extends Titulo {
    private String autorPrincipal;
    private String resumo;

    public Livro(String nome, String editora, double preco, String autorPrincipal, String resumo) {
        super(nome, editora, preco);
        this.autorPrincipal = autorPrincipal;
        this.resumo = resumo;
    }

    public String getAutorPrincipal() {
        return autorPrincipal;
    }

    public void setAutorPrincipal(String autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
    }

    public String getResumo() {
        //consultar resumo do livro
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAutor Principal: " + autorPrincipal + "\nResumo: " + resumo;
    }

    @Override
    public void imprimirNotaFiscal(int quantidade) {
        super.imprimirNotaFiscal(quantidade);
        System.out.println(getPreco() - getPreco() * 0.03);
    }
}
