package bar;

import pagamento.FormaPagamento;

import java.util.ArrayList;

public class Bar {
    private static ArrayList <Movimento> movimentos = new ArrayList<>();
    private static ArrayList <Produto> produtos = new ArrayList<>();
    private static ArrayList <FormaPagamento> formaPagamentos = new ArrayList<>();

    public static boolean addMovimento(Movimento movimento) {
        boolean didItWork = true;
        for (Movimento m : movimentos) {
            if (m != null && m.getMesa() == movimento.getMesa()) {
                didItWork = false;
                break;
            }
        }
        if (movimento.getStatus() != 9 && didItWork) {
            movimentos.add(movimento);
        }
        return didItWork;
    }

    public static boolean removeMovimento(int mesa) {
        boolean didItWork = false;
        for (Movimento m : movimentos) {
            if (m!= null && m.getMesa() == mesa) {
                movimentos.remove(m);
                didItWork = true;
                break;
            }
        }
        return didItWork;
    }

    public static void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public static boolean removeProduto(int codigo) {
        boolean didItWork = false;
        for (Produto p : produtos) {
            if (p!=null && p.getCodigo() == codigo) {
                produtos.remove(p);
                didItWork = true;
                break;
            }
        }
        return didItWork;
    }

    public static void addFormaPagamento(FormaPagamento formaPagamento) {
        if (formaPagamento != null) {
            formaPagamentos.add(formaPagamento);
        }
    }

    public static void removeFormaPagamento(int id) {
        for (FormaPagamento f : formaPagamentos) {
            if (f.getId() == id) {
                formaPagamentos.remove(f);
                break;
            }
        }
    }

    public void listaFormasPagamento() {
        for (FormaPagamento f : formaPagamentos) {
            System.out.println(f.toString());
        }
    }

    @Override
    public String toString() {
        String ret = "Movimentos: ";
        for (Movimento m: movimentos) {
            ret += "\n" + m.toString();
        }
        ret += "\n\nProdutos: ";
        for (Produto p: produtos) {
            ret += "\n" + p.toString();
        }
        return ret;
    }



}
