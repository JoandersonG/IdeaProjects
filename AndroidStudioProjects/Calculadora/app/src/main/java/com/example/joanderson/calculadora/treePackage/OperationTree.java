package com.example.joanderson.calculadora.treePackage;





public class OperationTree {

    private Tree tree;
    private OpNode lastOpNode;
    private NumNode lastNumNode;
    private Node lastAddedNode;

    public OperationTree() {
        tree = new Tree();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    public void insertNode(int key) {
        NumNode node = new NumNode(key);

        if (isEmpty()) {
            tree.setRoot(node);
        }
        else{
            lastOpNode.setRight(node);
            node.setFather(lastOpNode);
        }
        lastAddedNode = node;
        lastNumNode = node;
        tree.addSize();
    }

    public void insertNode(char key) {
        OpNode node = new OpNode(key);

        if (key == '+' || key == '-' || lastOpNode == null || (lastOpNode.getValue() == '*' || lastOpNode.getValue() == '/' )) {
            //se torna raiz
            node.setLeft(tree.getRoot());
            tree.getRoot().setFather(node);
            tree.setRoot(node);
        }
        else if (lastNumNode == tree.getRoot()) {
            //é '*' ou '/'
            //só tem um número que é raiz
            node.setLeft(tree.getRoot());
            tree.getRoot().setFather(node);
            tree.setRoot(node);
        }
	    else {
            lastNumNode.getFather().setRight(node);
            lastNumNode.setFather(node);
            node.setLeft(lastNumNode);
        }

        lastAddedNode = node;
        lastOpNode = node;
        tree.addSize();
    }

    public void removeLastAddedNode() {
        if (lastAddedNode == lastNumNode) {
            //tenho que remover um número
            if(lastNumNode != tree.getRoot()) {
                lastNumNode.getFather().setRight(null);
            }
            else{
                tree.setRoot(null);
            }
        }
        else {
            //tenho que remover um Operador

            if (lastOpNode == tree.getRoot()) {
                //é a raiz
                tree.setRoot(tree.getRoot().getLeft());
            }
            else {
                //é um '*' ou '/' pelo meio da árvore
                lastOpNode.getFather().setRight(lastOpNode.getLeft());
                lastOpNode.getLeft().setFather(lastOpNode.getFather());
            }

        }
        tree.subSize();
    }

    public double calculateTree() {
        return calculateTree(tree.getRoot());
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

