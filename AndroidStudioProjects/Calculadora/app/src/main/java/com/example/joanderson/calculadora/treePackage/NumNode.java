package com.example.joanderson.calculadora.treePackage;

public class NumNode extends Node {

    private double value;

    public NumNode(int value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
