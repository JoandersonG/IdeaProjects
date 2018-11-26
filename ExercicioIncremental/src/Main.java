import bar.*;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bar b1 = new Bar();
        Calendar dataDeAbertura = Calendar.getInstance();
        int mesa;
        Movimento mov;

        Movimento m;
        for (int i = 0; i < 5; i++) {
            System.out.print("Mesa: ");
            mesa = sc.nextInt();
            mov = new Movimento(mesa, dataDeAbertura);
            b1.addMovimento(mov);
            adicionarClientes(mov);
        }
        System.out.println(b1.toString());
        sc.close();

    }

    public static void adicionarClientes(Movimento mov) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adicionar novo cliente? (s/n) ");

        while (sc.nextLine().charAt(0) == 's') {
            System.out.print("É um cliente VIP? (s/n) ");
            if (sc.nextLine().charAt(0) == 's') {
                adicionarClienteVIP(mov);
            } else {
                System.out.print("É um cliente Especial? (s/n) ");
                if (sc.nextLine().charAt(0) == 's') {
                    adicionarClienteEspecial(mov);
                } else {
                    adicionarClienteNormal(mov);
                }
            }
            System.out.print("Adicionar novo cliente? (s/n) ");
        }
    }

    public static void adicionarClienteNormal(Movimento mov) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o ID do cliente: ");
        int id = sc.nextInt();
        System.out.print("Nome do cliente: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Tipo: (1 para pessoa física e 2 para pessoa jurídica): ");
        int tipo = sc.nextInt();
        while (tipo != 1 && tipo != 2) {
            System.out.println("Erro: valor inválido");
            System.out.print("Digite 1 para pessoa física e 2 para pessoa jurídica: ");
            tipo = sc.nextInt();
            System.out.println();
        }
        mov.addCliente(new Cliente(id, nome, tipo));
    }

    public static void adicionarClienteEspecial(Movimento mov) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o ID do cliente: ");
        int id = sc.nextInt();
        System.out.print("Nome do cliente: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Tipo: (1 para pessoa física e 2 para pessoa jurídica): ");
        int tipo = sc.nextInt();
        while (tipo != 1 && tipo != 2) {
            System.out.println("Erro: tipo inválido");
            System.out.print("Digite 1 para pessoa física e 2 para pessoa jurídica: ");
            tipo = sc.nextInt();
            System.out.println();
        }

        System.out.print("Digite o endereço: ");
        sc.nextLine();
        String endereco = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.nextLine();
        System.out.print("Sexo: (m: masculino, f: feminino, o:outro): ");
        char sexo = sc.nextLine().charAt(0);
        while (sexo != 'm' && sexo != 'f' && sexo != 'o') {
            System.out.println("Erro: sexo inválido.");
            System.out.print("Digite a letra'm' para masculino, 'f' para feminino e 'o' para outro: ");
            sexo = sc.nextLine().charAt(0);
        }

        mov.addCliente(new Especial(id, nome, tipo, endereco, telefone, email, sexo));

    }

    public static void adicionarClienteVIP(Movimento mov) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o ID do cliente: ");
        int id = sc.nextInt();
        System.out.print("Nome do cliente: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Tipo: (1 para pessoa física e 2 para pessoa jurídica): ");
        int tipo = sc.nextInt();
        while (tipo != 0 && tipo != 1) {
            System.out.println("Erro: tipo inválido");
            System.out.print("Digite 1 para pessoa física e 2 para pessoa jurídica: ");
            tipo = sc.nextInt();
            System.out.println();
        }
        System.out.print("Digite o endereço: ");
        sc.nextLine();
        String endereco = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.nextLine();
        System.out.print("Sexo: (m: masculino, f: feminino, o:outro): ");
        char sexo = sc.nextLine().charAt(0);
        while (sexo != 'm' && sexo != 'f' && sexo != 'o') {
            System.out.println("Erro: sexo inválido.");
            System.out.print("Digite a letra'm' para masculino, 'f' para feminino e 'o' para outro: ");
            sexo = sc.nextLine().charAt(0);
        }
        System.out.print("Limite: ");
        double limite = sc.nextDouble();
        System.out.print("Gerente: ");
        sc.nextLine();
        String gerente = sc.nextLine();
        mov.addCliente(new VIP(id, nome, tipo, endereco, telefone, email, sexo, limite, gerente));

    }

}