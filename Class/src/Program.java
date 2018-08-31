import entities.BankAccount;
import entities.Client;
import entities.Product;
import entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Client[] quarto = new Client[10];

        String name,email;
        int room;


        for (int i=0; i<n; i++) {
            System.out.println("Rent #" + i + ":");
            System.out.print("Name: ");
            sc.nextLine();
            name = sc.nextLine();
            sc.nextLine();
            System.out.print("Email: ");
            email = sc.nextLine();
            sc.nextLine();
            System.out.print("Room: ");
            room = sc.nextInt();
            System.out.println();
            quarto[room] = new Client(name,email,room);
        }

        System.out.println("Busy rooms: ");

        for (int i=0; i<quarto.length; i++) {
            if(quarto[i]!=null){
                System.out.println(i + ": " + quarto[i].toString());
            }
        }


        sc.close();
    }
}
