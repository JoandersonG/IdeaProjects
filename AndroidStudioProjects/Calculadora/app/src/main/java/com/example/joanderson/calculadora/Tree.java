package com.example.joanderson.calculadora;

/**
 * Created by joanderson on 12/08/18.
 */

public class Tree {
    Node root = new Node();
    int size;
    public void setIgnoreRoot(){
        this.root.setValue("ignore");
    }
}
