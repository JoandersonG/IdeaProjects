//package com.example.joanderson.calculadora.treePackage;

/**
 * Created by joanderson on 12/08/18.
 */

public abstract class Node{

    private Node father;

    public void setFather(Node father){
        this.father=father;
    }
    public Node getFather(){
        return this.father;
    }

}
