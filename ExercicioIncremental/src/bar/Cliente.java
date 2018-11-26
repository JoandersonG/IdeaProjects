package bar;

public class Cliente {
    private int id;
    private String nome;
    private int tipo;
    private int categoria;

    public Cliente(int id, String nome, int tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = 0;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n ID: " + id + "\n Tipo: " + tipo + "\n Categoria: " + categoria;
    }
}
