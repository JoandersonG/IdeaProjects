//package com.example.joanderson.calculadora.treePackage;

public class OpNode extends Node {

    private Node left;
    private Node right;
    private char value;

    public OpNode(char value) {
        this.value = value;
    }

    public void setLeft(Node left){
        this.left=left;
    }
    public void setRight(Node right){
        this.right=right;
    }
    public Node getLeft(){
        return this.left;
    }
    public Node getRight(){
        return this.right;
    }
    public void setValue(char value){
        this.value=value;
    }
    public char getValue(){
        return this.value;
    }
}
