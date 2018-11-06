package com.example.joanderson.calculadora.treePackage;

public class ParenNode extends Node {

    private OperationTree subOperationTree;

    public ParenNode() {
        super('(');
        subOperationTree = new OperationTree();
    }

    public char getValue(){
        return super.value;
    }

    public double resultado() {
        return subOperationTree.calculateTree();
    }

    public void addNo(double key) {
        subOperationTree.addNode(key);
    }

    public void addNo(char key) {
        subOperationTree.addNode(key);
    }

    public Node lastAddedNode() {
        return subOperationTree.lastAddedNode();
    }

    public boolean removerUltimoNo() {
        return subOperationTree.removeLastAddedNode();
    }

    public boolean isEmpty() {
        return subOperationTree.isEmpty();
    }
}
