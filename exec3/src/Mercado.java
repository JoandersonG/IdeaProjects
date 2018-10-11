
import java.util.ArrayList;


public class Mercado {
    private ArrayList <Cliente> clientes;
    private ArrayList <Produto> produtos;

    public Mercado() {
     clientes = new ArrayList<Cliente>();
     produtos = new ArrayList<Produto>();
    }
    
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void remCliente(Cliente cliente) {
        if (!clientes.isEmpty()){
            clientes.remove(cliente);
        }
    }

    public void remProduto(int iterator) {
        if (iterator <= produtos.size()-1 && iterator >= 0 && !produtos.isEmpty()){
            produtos.remove(iterator);
        }
    }
    
    public void addProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public void remProduto(Produto produto) {

        if (produto != null && !produtos.isEmpty()){
            produtos.remove(produto);
        }
    }
    
    public Cliente isCliente(String codigoCliente) {

        for(int i = 0; i< clientes.size(); i++){
            if (clientes.get(i).getCodigo().compareTo(codigoCliente) == 0){
                return clientes.get(i);
            }
        }
        
        return null;
    }

    public Produto isProduto(int codigoProduto) {

        for(int i = 0; i< produtos.size(); i++){
            if (produtos.get(i).getCodigo() == codigoProduto){
                return produtos.get(i);
            }
        }
        return null;
    }
}
