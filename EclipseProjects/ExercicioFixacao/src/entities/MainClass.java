package entities;


import java.util.Locale;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ContaCorrente cc = new ContaCorrente(30,123,0,0,120);
        System.out.println(cc.lancOp(140, 'D'));
    }
}
