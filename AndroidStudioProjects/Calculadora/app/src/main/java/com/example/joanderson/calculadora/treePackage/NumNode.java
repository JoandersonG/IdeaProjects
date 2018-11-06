package com.example.joanderson.calculadora.treePackage;

public class NumNode extends Node {

    private double number;

    public NumNode(double number) {
        super('n');
        this.number = number;
    }

    public char getValue(){
        return super.value;
    }

    public double getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
