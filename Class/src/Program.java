

import entities.ContaCorrente;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ContaCorrente cc = new ContaCorrente(785432,123,1,0,1200);
        System.out.println(cc.calc2DigV());

    }
}
