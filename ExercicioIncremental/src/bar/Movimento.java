package bar;

import java.util.ArrayList;
import java.util.Calendar;

public class Movimento {
    private int mesa;
    private Calendar dataAbertura;
    private Calendar dataFechamento;
    private int status;
    private ArrayList <Pedido> pedidos;
    private  ArrayList <Cliente> clientes;

    public Movimento(int mesa, Calendar dataAbertura) {
        this.mesa = mesa;
        this.dataAbertura = dataAbertura;
        this.status = 0;
        this.pedidos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void removeCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                clientes.remove(c);
                break;
            }
        }
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedido(Pedido p) {
        pedidos.add(p);
    }

    public void removePedido(Pedido p) {
        pedidos.remove(p);
    }

    public void pagar(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
        this.status = 1;
    }

    public void fechar(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
        this.status = 9;
    }

    @Override
    public String toString() {

        String ret = "Mesa: " + mesa + "\nData de abertura: " + dataAbertura + "\nData de fechamento: " + dataFechamento + "\nStatus: " + status;
        ret += "\nPedidos: ";
        for (Pedido p : pedidos) {
            ret += "\n" + p.toString();
        }
        ret += "\nClientes: ";
        for (Cliente c: clientes) {
            ret += "\n" + c.toString();
        }
        return ret;
    }
}
