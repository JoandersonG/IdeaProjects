//package com.example.joanderson.calculadora.treePackage;

public class ParenNode extends Node {

    private final char value = '(';
    private OperationTree subTree;

    public ParenNode() {
        subTree = new OperationTree();
    }
    public char getValue(){
        return this.value;
    }

    public double resultado() {
        return subTree.calculateTree();
    }

    public void addNo(double key) {
        subTree.addNode(key);
    }

    public void addNo(char key) {
        subTree.addNode(key);
    }

    public void removerUltimoNo() {
        subTree.removeLastAddedNode();
    }

    public boolean isEmpty() {
        return subTree.isEmpty();
    }
}
