package com.example.joanderson.calculadora;

/**
 * Created by joanderson on 12/08/18.
 */

public class Node{
    private Node left;
    private Node right;
    private Node father;
    private String value;

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
    public void setFather(Node father){
        this.father=father;
    }
    public Node getFather(){
        return this.father;
    }
    public void setValue(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
}
