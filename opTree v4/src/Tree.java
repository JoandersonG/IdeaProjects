//package com.example.joanderson.calculadora.treePackage;

/**
 * Created by joanderson on 12/08/18.
 */

 class Tree {
    private Node root;
    public Tree() {
        this(null);
    }

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null || root.getClass() == ParenNode.class;
    }
}
