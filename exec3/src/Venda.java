

import java.util.ArrayList;

public class Venda {
    
    private Mercado mercado;
    private Cliente cliente;
    private ArrayList <ItemVenda> itensVenda;

    public Venda(Mercado mercado, String codigoCliente) {
        Cliente cliente = mercado.isCliente(codigoCliente);
        if (cliente != null) {
            itensVenda = new ArrayList<>();
            this.mercado = mercado;
            this.cliente = cliente;
        }
    }

    public void addItemVenda(int codigoProduto) {
        addItemVenda(codigoProduto,1);
    }

    public void addItemVenda(int codigoProduto, int quantidade) {
        Produto produto = mercado.isProduto(codigoProduto);
        if (produto != null) {
            itensVenda.add(new ItemVenda(produto,quantidade));
        }

    }

    public void removeItemVenda(int codigoProduto) {
        mercado.remProduto(mercado.isProduto(codigoProduto));
    }

    public void removeItemVendaIterator(int iterator) {
        mercado.remProduto(iterator);
    }

    public int valorTotalVenda() {
        int soma = 0;
        for (ItemVenda it: itensVenda) {
            soma += it.getProduto().getPrecoUnitario() * it.getQuantidade();
        }
        return soma;
    }


    
}
