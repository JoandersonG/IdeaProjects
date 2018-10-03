package entities;

public class Pedido {
    private int numero;
    private Produto produto;
    private int status;

    public Pedido(int numero, Produto produto) {
        this(numero,produto,0);
    }

    public Pedido(int numero, Produto produto, int status) {
        this.numero = numero;
        this.produto = produto;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void servir() {
        this.status = 1;
    }

    public void cancelar() {
        this.status = 9;
    }

}
