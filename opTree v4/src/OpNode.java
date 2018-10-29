//package com.example.joanderson.calculadora.treePackage;

public class OpNode extends Node {


    private char value;

    public OpNode(char value) {
        this.value = value;
    }
    public void setValue(char value){
        this.value=value;
    }
    public char getValue(){
        return this.value;
    }
}
