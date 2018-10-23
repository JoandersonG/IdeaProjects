//package com.example.joanderson.calculadora.treePackage;

/**
 * Created by joanderson on 12/08/18.
 */

 class Tree {
    private Node root;
    private int size;

    public Tree() {
        this(null);
    }

    public Tree(Node root) {
        this.root = root;
        this.size = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void addSize() {
        this.size++;
    }

    public void subSize() {
        this.size--;
    }

    public boolean isEmpty() {
        return root == null || root.getClass() == ParenNode.class;
    }
}
