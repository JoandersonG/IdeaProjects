package pagamento;

public class FormaPagamento {

    private int id;
    private String nome;
    private boolean ativo;

    public FormaPagamento(int id, String nome, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Forma de Pagamento:\n" +
                "id : " + id +
                "\nnome : " + nome  +
                "\nativo : " + ativo + "\n";
    }
}
