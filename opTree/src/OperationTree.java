//package com.example.joanderson.calculadora.treePackage;

import java.util.ArrayList;
import java.util.Stack;

public class OperationTree {

    private Tree tree;
    private int itArrayList, itEstadoPassado;
//    private OpNode lastOpNode;
//    private NumNode lastNumNode;
//    private Node lastAddedNode;
//

    //private Stack <LastOcourrence> lastOcourrences;
    private ArrayList <LastOcourrence> lastOcourrences;

    public OperationTree() {
        itArrayList = 0;
        itEstadoPassado = 0;
        tree = new Tree();
   //     rootStack = new Stack<>();
        lastOcourrences = new ArrayList<>();
        //lastOcourrences.push( new LastOcourrence());
        lastOcourrences.add(new LastOcourrence());
        //lastOcourrences.peek().setRoot(tree.getRoot());
        lastOcourrences.get(itArrayList).setRoot(tree.getRoot());

    }

    public boolean isEmpty() {
        //return tree.isEmpty();
        //return (lastOcourrences.size() == 1 && lastOcourrences.peek().getRoot() == null) || lastOcourrences.isEmpty();
        //return lastOcourrences.peek().getRoot() == null;
        return  lastOcourrences.get(itArrayList).getRoot() == null;
    }

    public void addNode(double key) {
        NumNode node = new NumNode(key);
/*
        if (tree.getRoot().getClass() == ParenNode.class) {
            rootStack.add(tree.getRoot());
            lastAddedNode

        }
*/
        if (isEmpty()) {
            //tree.setRoot(node);
            //lastOcourrences.peek().setRoot(node);
            lastOcourrences.get(itArrayList).setRoot(node);
        }
        else{
            //lastOpNode.setRight(node);
            lastOcourrences.get(itArrayList).getLastOpNode().setRight(node);
            //node.setFather(lastOpNode);
            node.setFather(lastOcourrences.get(itArrayList).getLastOpNode());
        }
        //lastAddedNode = node;
        lastOcourrences.get(itArrayList).setLastAddedNode(node);
        //lastNumNode = node;
        lastOcourrences.get(itArrayList).setLastNumNode(node);
        //tree.addSize();
    }

    public void addNode(char key) {
        
  /*      
        if (key == '(') {//olhar isso
            ParenNode pn = new ParenNode();
            rootStack.add(tree.getRoot());
            tree.setRoot(n);
        }
*/
        if (key == '(') {
//            if(lastOcourrences.size() > 1) {
//                lastOcourrences.push( new LastOcourrence());
//            }
            //lastOcourrences.push( new LastOcourrence());
            lastOcourrences.add(new LastOcourrence());
            itEstadoPassado = itArrayList;
            itArrayList = lastOcourrences.size()-1;
            return;
        }
        if (key == ')') {
            //double resultado = calculateTree(lastOcourrences.pop().getRoot());
            double resultado = calculateTree(lastOcourrences.get(itArrayList).getRoot());
            itArrayList = itEstadoPassado;
            addNode(resultado);
            return;
        }
        OpNode node = new OpNode(key);

        if (key == '+'
                || key == '-'
                || lastOcourrences.get(itArrayList).getLastOpNode() == null
                || (lastOcourrences.get(itArrayList).getLastOpNode().getValue() == '*'
                || lastOcourrences.get(itArrayList).getLastOpNode().getValue() == '/' )) {

            //se torna raiz
            //node.setLeft(tree.getRoot());
            node.setLeft(lastOcourrences.get(itArrayList).getRoot());
            //tree.getRoot().setFather(node);
            lastOcourrences.get(itArrayList).getRoot().setFather(node);
            //tree.setRoot(node);
            lastOcourrences.get(itArrayList).setRoot(node);
        }
        //else if (lastNumNode == tree.getRoot()) {
        else if (lastOcourrences.get(itArrayList).getLastNumNode() == lastOcourrences.get(itArrayList).getRoot()) {
            //é '*' ou '/'
            //só tem um número que é raiz
            //node.setLeft(tree.getRoot());
            node.setLeft(lastOcourrences.get(itArrayList).getRoot());
            //tree.getRoot().setFather(node);
            lastOcourrences.get(itArrayList).getRoot().setFather(node);
            //tree.setRoot(node);
            lastOcourrences.get(itArrayList).setRoot(node);
        }
	    else {
            //lastNumNode.getFather().setRight(node);
            lastOcourrences.get(itArrayList).getLastNumNode().getFather().setRight(node);
            //lastNumNode.setFather(node);
            lastOcourrences.get(itArrayList).getLastNumNode().setFather(node);
            //node.setLeft(lastNumNode);
            node.setLeft(lastOcourrences.get(itArrayList).getLastNumNode());
        }

        //lastAddedNode = node;
        lastOcourrences.get(itArrayList).setLastAddedNode(node);
        //lastOpNode = node;
        lastOcourrences.get(itArrayList).setLastOpNode(node);
        //tree.addSize();
    }

    public void removeLastAddedNode() {
        if (lastOcourrences.get(itArrayList).getLastAddedNode() == null && lastOcourrences.get(itArrayList).getRoot() == null) {
            //tenho que remover um '('
            lastOcourrences.remove(itArrayList);
            itArrayList = itEstadoPassado;... //e se ...(...(...(...)...)...)...
        }
        else if (lastOcourrences.get(itArrayList).getLastAddedNode() == lastOcourrences.get(itArrayList).getLastNumNode()) {
            //tenho que remover um número
            if(lastOcourrences.get(itArrayList).getLastNumNode() != lastOcourrences.get(itArrayList).getRoot()) {
                lastOcourrences.get(itArrayList).getLastNumNode().getFather().setRight(null);
            }
            else{
                //tree.setRoot(null);//todo: talves apagar isso
                lastOcourrences.get(itArrayList).setRoot(null);
            }
        }
        else if(lastOcourrences.get(itArrayList).getLastAddedNode() == lastOcourrences.get(itArrayList).getLastOpNode()) {
            //tenho que remover um Operador

            if (lastOcourrences.get(itArrayList).getLastOpNode() == lastOcourrences.get(itArrayList).getRoot()) {
                //é a raiz
                //tree.setRoot(tree.getRoot().getLeft());
                lastOcourrences.get(itArrayList).setRoot(lastOcourrences.get(itArrayList).getRoot().getLeft());
            }
            else {
                //é um '*' ou '/' pelo meio da árvore
                lastOcourrences.get(itArrayList).getLastOpNode().getFather().setRight(
                        lastOcourrences.get(itArrayList).getLastOpNode().getLeft()
                );
                lastOcourrences.get(itArrayList).getLastOpNode().getLeft().setFather(
                        lastOcourrences.get(itArrayList).getLastOpNode().getFather()
                );
            }

        }
        else {
            //remover um ')'
            ...
        }
        //tree.subSize();
    }

    public double calculateTree() {
        double resultado = 0;
        //return calculateTree(tree.getRoot());

        for (LastOcourrence lo : lastOcourrences) {
            resultado += calculateTree(lo.getRoot());
        }

        return resultado;
    }

    private double calculateTree(Node root) {
        if (root == null) {
            return 0;
        }
        if(root.getClass() == OpNode.class) {
            OpNode opn =  (OpNode) root;
            return calculateTree(opn);
        }
        else {
            NumNode nn =  (NumNode) root;
            return calculateTree(nn);
        }
    }

    private double calculateTree(NumNode root) {
        if (root == null) {
            System.out.println("Erro: NumNode null");
            return 0;
        }
        return root.getValue();
    }

    private double calculateTree(OpNode root) {
        if (root == null) {
            System.out.println("Erro: OpNode null");
            return 0;
        }

        switch (root.getValue()) {
            case '+':
                return calculateTree(root.getLeft()) + calculateTree(root.getRight());
            case '-':
                return calculateTree(root.getLeft()) - calculateTree(root.getRight());
            case '*':
                return calculateTree(root.getLeft()) * calculateTree(root.getRight());
            case '/':
                return calculateTree(root.getLeft()) / calculateTree(root.getRight());
            default:
                return 0;
        }
    }

}

