package entities;

import java.util.ArrayList;
import java.util.Calendar;

public class Movimento {
    private int mesa;
    private Calendar dataAbertura;
    private Calendar dataFechamento;
    private int status;
    private ArrayList<Pedido> pedidos;

    public Movimento(int mesa, Calendar dataAbertura) {
        this.mesa = mesa;
        this.dataAbertura = dataAbertura;
        this.status = 0;
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

    public void pagar(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
        this.status = 1;
    }

    public void fechar(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
        this.status = 9;
    }
}
