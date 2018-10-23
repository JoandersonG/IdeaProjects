//package com.example.joanderson.calculadora.treePackage;

/**
 * Created by joanderson on 12/08/18.
 */

public abstract class Node{
    private Tree left;
    private Tree right;
    private Tree father;

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

}
