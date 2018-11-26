package bar;

public class Produto {
    private int codigo;
    private String nome;
    private int tipo;
    private Double preco;
    private boolean disponibilidade;

    public Produto(int codigo, String nome, int tipo) {
        this(codigo,nome,tipo,null,false);
    }

    public Produto(int codigo, String nome, int tipo, Double preco, boolean disponiblidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        String ret = "Código: " + codigo + "\nNome: " + nome + "\nTipo: " + tipo;
        if (preco != null) {
            ret += "\nPreço: " + preco;
        }
        ret += "\nDisponibilidade: " + disponibilidade;
        return ret;
    }
}
