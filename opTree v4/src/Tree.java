
//package com.example.joanderson.calculadora.treePackage;
/**
 * Created by joanderson on 12/08/18.
 */

class Tree {
    private Node root;
    private Integer size;
    private boolean isParenthesis = false;

    public Tree() {
        this.root = null;
        this.size = 0;
    }

    public Tree(Node root) {
        this.root = root;
        this.size = 1;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

/*    public boolean isEmpty() {
        return root == null || root.getClass() == ParenNode.class;
    }*/
    public boolean isEmpty() {
        return this.size == 0;
    }

    public Node lastAddedNode() {
        if (root == null) {
            return null;
        }
        Node aux = root;
        while (aux.getRight() != null) {
            aux = aux.getRight();
        }
        return aux;
    }

    public void addNode(char operation) {
        this.size++;

        if (isParenthesis) {
            ParenNode pn = (ParenNode) lastAddedNode();
            pn.addNo(operation);
        }

        OpNode node = new OpNode (operation);

        if(operation == '(') {

        }
        if (node.getValue() == '+' || node.getValue() == '-') {
            root.setFather(node);
            node.setLeft(root);
            setRoot(node);
            return;
        }

        if (node.getValue() == '*' || node.getValue() == '/') {
            node.setLeft(root);
            root.setFather(node);
            setRoot(node);
            return;
        }
    }

    public void addNode(int number) {

    }

    public void addNode()
}
