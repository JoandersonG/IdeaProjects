import bar.Bar;
import pagamento.TipoCredito;
import pagamento.TipoDebito;
import pagamento.TipoDinheiro;
import pagamento.TipoVoucher;

import java.util.Scanner;

public class mainParaPagamentos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bar bar1 = new Bar();


        System.out.print("Gostaria de adicionar um novo método de pagamento? (s/n): ");
        char gostaria = sc.nextLine().charAt(0);
        int opcao;
        while (gostaria == 's') {
            System.out.println("Opções: ");
            System.out.println("1. Crédito");
            System.out.println("2. Débito");
            System.out.println("3. Dinheiro");
            System.out.println("4. Voucher");
            System.out.print("\n digite a opção desejada: ");
            opcao = sc.nextInt();
            adicionarPagamento(opcao, bar1);
            System.out.print("Gostaria de adicionar um novo método de pagamento? (s/n): ");
            sc.nextLine();
            gostaria = sc.nextLine().charAt(0);
        }

        bar1.listaFormasPagamento();

    }

    public static void adicionarPagamento(int opcao, Bar bar) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite se está ativo (s/n): ");
        boolean ativo = (sc.nextLine().charAt(0) == 's');

        switch (opcao) {
            case 1:
                System.out.print("Taxa de retenção: ");
                double taxaRet = sc.nextDouble();
                System.out.print("Digite o prazo de pagamento: ");
                int prazo = sc.nextInt();
                bar.addFormaPagamento(new TipoCredito(id,nome,ativo,taxaRet,prazo));
                break;

            case 2:
                System.out.print("Taxa de retenção: ");
                double taxaRetencao = sc.nextDouble();
                sc.nextLine();
                System.out.print("Conta corrente: ");
                String contaCorrente = sc.nextLine();
                bar.addFormaPagamento(new TipoDebito(id,nome,ativo,taxaRetencao,contaCorrente));
                break;
            case 3:
                System.out.println();
                System.out.println("Formas: ");
                System.out.println();
                System.out.println("0: em dinheiro");
                System.out.println("1: depósito em conta");
                System.out.println("2: DOC");
                System.out.println("3: TED");
                System.out.println("4: Cheque");
                System.out.println("9: outras");
                System.out.print("\n Digite a forma desejada: ");
                int forma = sc.nextInt();
                bar.addFormaPagamento(new TipoDinheiro(id,nome,ativo,forma));
                break;
            case 4:
                System.out.print("Diária: ");
                Double diaria = sc.nextDouble();
                System.out.print("Digite o prazo de pagamento: ");
                int prazoPag = sc.nextInt();
                sc.nextLine();
                System.out.print("Conta corrente: ");
                String contaCorr = sc.nextLine();
                bar.addFormaPagamento(new TipoVoucher(id,nome,ativo,diaria,prazoPag,contaCorr));
                break;

        }
    }
}
