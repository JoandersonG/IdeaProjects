package entities;

public class BankAccount {
    private int number;
    private String holder;
    private double saldo;

    public BankAccount(int number, String holder){
        this.number = number;
        this.holder = holder;
    }

    public BankAccount(int number, String holder, double saldo){
        this.number = number;
        this.holder = holder;
        this.saldo = saldo;
    }

    public int getNumber() {
        return number;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void withdraw(double value) {
        saldo -= value + 5;
    }

    public void deposit(double value) {
        saldo += value;
    }

}
