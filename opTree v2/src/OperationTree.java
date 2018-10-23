//package com.example.joanderson.calculadora.treePackage;

public class OperationTree {

    private Tree raiz;
    //private int itArrayList;
    private Tree lastOpNode;
    private Tree lastNumNode;
    private Tree lastAddedNode;
//

    //private Stack <LastOcourrence> lastOcourrences;
    //private ArrayList <LastOcourrence> lastOcourrences;

    public OperationTree() {
        //itArrayList = 0;
        //raiz = new Tree();
   //     rootStack = new Stack<>();
        //lastOcourrences = new ArrayList<>();
        //lastOcourrences.push( new LastOcourrence());
        //lastOcourrences.add(new LastOcourrence());
        //lastOcourrences.peek().setSubRoot(tree.getSubRoot());
        //lastOcourrences.get(itArrayList).setSubRoot(tree.getSubRoot());

    }

    public boolean isEmpty() {
        //return tree.isEmpty();
        //return (lastOcourrences.size() == 1 && lastOcourrences.peek().getSubRoot() == null) || lastOcourrences.isEmpty();
        //return lastOcourrences.peek().getSubRoot() == null;
        //return  lastOcourrences.get(itArrayList).getSubRoot() == null;
        return raiz.isEmpty();
    }

    public void addNode(double key) {
        //NumNode node = new NumNode(key);
/*
        if (tree.getSubRoot().getClass() == ParenNode.class) {
            rootStack.add(tree.getSubRoot());
            lastAddedNode

        }
*/
        //NumTree node = new NumTree(key);
        Tree node = new Tree(new NumNode(key));
        if (isEmpty()) {
            //tree.setSubRoot(node);
            //lastOcourrences.peek().setSubRoot(node);
            //lastOcourrences.get(itArrayList).setSubRoot(node);
            raiz = node;
        }
        else{
            lastOpNode.setRight(node);
            //lastOcourrences.get(itArrayList).getLastOpNode().setRight(node);
            //node.setFather(lastOpNode);
            node.setFather(lastOpNode);
        }
        //lastAddedNode = node;
        lastAddedNode = node;
        lastNumNode = node;
        //lastOcourrences.get(itArrayList).setLastNumNode(node);
        //tree.addSize();
    }

    public void addNode(char key) {
        
  /*      
        if (key == '(') {//olhar isso
            ParenNode pn = new ParenNode();
            rootStack.add(tree.getSubRoot());
            tree.setSubRoot(n);
        }
*/
        if (key == '(') {

            //lastOcourrences.add(new LastOcourrence());
            //itArrayList = lastOcourrences.size()-1;

            return;
        }
        if (key == ')') {
            //double resultado = calculateTree(lastOcourrences.pop().getSubRoot());
            double resultado = calculateTree(lastOcourrences.get(itArrayList).getRoot());
            ...itArrayList = 0;// it tem que voltar para o estado anterior
            OperationTree op = new OperationTree();
            //lastOcourrences.pop();
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
            //node.setLeft(tree.getSubRoot());
            node.setLeft(lastOcourrences.get(itArrayList).getRoot());
            //tree.getSubRoot().setFather(node);
            lastOcourrences.get(itArrayList).getRoot().setFather(node);
            //tree.setSubRoot(node);
            lastOcourrences.get(itArrayList).setRoot(node);
        }
        //else if (lastNumNode == tree.getSubRoot()) {
        else if (lastOcourrences.get(itArrayList).getLastNumNode() == lastOcourrences.get(itArrayList).getRoot()) {
            //é '*' ou '/'
            //só tem um número que é raiz
            //node.setLeft(tree.getSubRoot());
            node.setLeft(lastOcourrences.get(itArrayList).getRoot());
            //tree.getSubRoot().setFather(node);
            lastOcourrences.get(itArrayList).getRoot().setFather(node);
            //tree.setSubRoot(node);
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
            ...
        }
        else if (lastOcourrences.get(itArrayList).getLastAddedNode() == lastOcourrences.get(itArrayList).getLastNumNode()) {
            //tenho que remover um número
            if(lastOcourrences.get(itArrayList).getLastNumNode() != lastOcourrences.get(itArrayList).getRoot()) {
                lastOcourrences.get(itArrayList).getLastNumNode().getFather().setRight(null);
            }
            else{
                //tree.setSubRoot(null);//todo: talves apagar isso
                lastOcourrences.get(itArrayList).setRoot(null);
            }
        }
        else if(lastOcourrences.get(itArrayList).getLastAddedNode() == lastOcourrences.get(itArrayList).getLastOpNode()) {
            //tenho que remover um Operador

            if (lastOcourrences.get(itArrayList).getLastOpNode() == lastOcourrences.get(itArrayList).getRoot()) {
                //é a raiz
                //tree.setSubRoot(tree.getSubRoot().getLeft());
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
    /*
    public double calculateTree() {
        double resultado = 0;
        //return calculateTree(tree.getSubRoot());

        for (LastOcourrence lo : lastOcourrences) {
            resultado += calculateTree(lo.getSubRoot());
        }

        return resultado;
    }
    */















    public double calcularArv() {
        return calcularArv(raiz);
    }

    private double calcularArv(Tree raiz) {
        if (raiz == null || raiz.getSubRoot() == null) {
            return 0;
        }
        double resultado = 0;


        resultado += raiz.getLeft().





        if (raiz.getSubRoot().getLeft() != null) {
            resultado += calculateTree(raiz.getSubRoot().getLeft().getSubRoot());
        }
        if (raiz.getSubRoot().getRight() != null) {
            resultado += calculateTree(raiz.getSubRoot().getRight().getSubRoot());
        }
        resultado += calcularArv(raiz.getSubRoot().getLeft());
        resultado += calcularArv(raiz.getSubRoot().getRight());
        return resultado;
    }










    //-----------------------------------------------------------------------



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
                return calculateTree(root.getLeft().getSubRoot()) + calculateTree(root.getRight().getSubRoot());
            case '-':
                return calculateTree(root.getLeft().getSubRoot()) - calculateTree(root.getRight().getSubRoot());
            case '*':
                return calculateTree(root.getLeft().getSubRoot()) * calculateTree(root.getRight().getSubRoot());
            case '/':
                return calculateTree(root.getLeft().getSubRoot()) / calculateTree(root.getRight().getSubRoot());
            default:
                return 0;
        }
    }

}

