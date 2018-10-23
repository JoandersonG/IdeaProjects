//package com.example.joanderson.calculadora.treePackage;

/**
 * Created by joanderson on 12/08/18.
 */

 public class Tree {
    private Node subRoot;
    private Tree left;
    private Tree right;
    private Tree father;

    public Tree() {
        this(null);
    }

    public Tree(Node subRoot) {
        this.subRoot = subRoot;
    }

    public void setLeft(Tree left){
        this.left = left;
    }
    public Tree getLeft(){
        return this.left;
    }
    public void setRight(Tree right){
        this.right = right;
    }
    public Tree getRight(){
        return this.right;
    }
    public void setFather(Tree father){
        this.father = father;
    }
    public Tree getFather(){
        return this.father;
    }



    public Node getSubRoot() {
        return subRoot;
    }

    public void setSubRoot(Node subRoot) {
        this.subRoot = subRoot;
    }


    public boolean isEmpty() {
        return subRoot == null;
    }
}
