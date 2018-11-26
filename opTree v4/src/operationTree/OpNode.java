package operationTree;//package com.example.joanderson.calculadora.treePackage;

public class OpNode extends Node {

    private Node left;
    private Node right;

    OpNode(char op) {
        super(op);
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
}
