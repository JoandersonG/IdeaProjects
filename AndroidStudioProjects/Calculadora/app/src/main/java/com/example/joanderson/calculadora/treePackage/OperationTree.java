package com.example.joanderson.calculadora.treePackage;

public class OperationTree {
    private Node root;
    private Integer size;
    private Boolean isParenthesis = false;

    public OperationTree() {
        this.root = null;
        this.size = 0;
    }

    public OperationTree(Node root) {
        this.root = root;
        this.size = 1;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Node lastAddedNode() {
        return lastAddedNode(this.root);
    }

    private Node lastAddedNode(Node root) {
        if (root == null) {
            return null;
        }

        if (root.getValue() == 'n' || root.getValue() == '(') {
            //it's a parenthesis or a number
            return root;
        }

        //it's an operator
        OpNode node = (OpNode) root;
        if (node.getRight() == null) {
            return node;
        }

        return lastAddedNode(node.getRight());
    }

    public void addNode(double number) {
        if (isParenthesis) {

            //last added node is a parenthesis

            ((ParenNode) lastAddedNode()).addNo(number);
            return;
        }

        NumNode node = new NumNode(number);

        if (lastAddedNode() == null) {
            root = node;
            return;
        }


        //then last added node is an operator

        Node lastAdded = lastAddedNode();
        node.setFather(lastAdded);
        ((OpNode) lastAdded).setRight(node);
    }


    public void addNode(char operation) {

        if(isParenthesis && operation != ')') {
            ParenNode pn = (ParenNode) lastAddedNode();
            pn.addNo(operation);
            return;
        }

        if (operation == '(') {
            ParenNode pn = new ParenNode();
            addParenNode(pn);
            isParenthesis = true;
            return;
        }

        if (operation == '+' || operation == '-') {
            OpNode op = new OpNode(operation);
            addPlusSubNode(op);
            return;
        }

        if (operation == '*' || operation == '/') {
            OpNode op = new OpNode(operation);
            addDivideMultiNode(op);
            return;
        }

        //it's a parenthesis closure

        ParenNode pn = (ParenNode) lastAddedNode();

        if (pn.lastAddedNode().getValue() == '(') {

            // if last added node was a parenthesis and inside it the last added node as a parenthesis

            pn.addNo(')');
            return;
        }

        //then this is the last opened parenthesis

        isParenthesis = false;

    }

    private void addParenNode(ParenNode node) {
        this.size++;
        if (root == null) {
            root = node;
            return;
        }

        // lastAddedNode is necessarily an OpNode
        OpNode last = (OpNode) lastAddedNode();
        last.setRight(node);
        node.setFather(last);
    }

    private void addNumNode(NumNode node) {
        this.size++;
        if (root == null) {
            root = node;
            return;
        }

        // lastAddedNode is necessarily an OpNode
        OpNode last = (OpNode) lastAddedNode();
        last.setRight(node);
        node.setFather(last);
    }

    private void addPlusSubNode(OpNode node) {

        //the way add and subtraction nodes work in the tree is similar to each other

        this.size++;
        if (root == null) {
            root = node;
            return;
        }
        // always becomes the root
        root.setFather(node);
        node.setLeft(root);
        root = node;
        return;
    }

    private void addDivideMultiNode(OpNode node) {
        //the way divide and multiplication nodes work in the tree is similar to each other
        this.size++;
        if (root == null) {
            root = node;
            return;
        }

        //last added node is a number or parenthesis

        Node lastAddedNode = lastAddedNode();
        node.setFather(lastAddedNode.getFather());
        OpNode lan = (OpNode) lastAddedNode.getFather();
        if (lan != null) {
            lan.setRight(node);
        }
        else {
            root = node;
        }
        lastAddedNode.setFather(node);
        node.setLeft(lastAddedNode);

    }

    public double calculateTree() {

        return calculateTree(this.root);

    }

    private double calculateTree(Node root){

        if (root == null) {
            return 0;
        }

        if (root.getValue() == '(') {
            return ((ParenNode) root).resultado();
        }

        if (root.getValue() == 'n') {
            return ((NumNode) root).getNumber();
        }

        //it's an operator

        double result = calculateTree(((OpNode) root).getLeft());

        switch (root.getValue()) {
            case '+':
                return result += calculateTree(((OpNode) root).getRight());
            case '-':
                return result -= calculateTree(((OpNode) root).getRight());
            case '*':
                return result *= calculateTree(((OpNode) root).getRight());
            case '/':
                return result /= calculateTree(((OpNode) root).getRight());
            default:
                return 0;
        }
    }

    public boolean removeLastAddedNode() {

        if (root == null) {
            return false;
        }

        Node lastAdded = lastAddedNode();
        this.size--;

        if (isParenthesis && ((ParenNode) lastAdded).removerUltimoNo()){

            //last added node into the parenthesis was removed successfully

            return true;
        }

        if (isParenthesis) {
            //last added node is an empty parenthesis
            OpNode op = (OpNode) lastAdded.getFather();
            lastAdded.setFather(null);
            if (op != null) {
                op.setRight(null);
            }
            else {
                //one member in the tree
                root = null;
            }
            isParenthesis = false;
            return true;
        }

        if (lastAdded.getValue() == 'n') {
            //last added node is a number
            OpNode op = (OpNode) lastAdded.getFather();
            lastAdded.setFather(null);
            if (op != null) {
                op.setRight(null);
            }
            else {
                //one member in the tree
                root = null;
            }
            return true;
        }

        if (lastAdded.getValue() == '(') {
            //last added node was an ')'
            isParenthesis = true;
            return true;
        }

        if (lastAdded.getValue() == '+' || lastAdded.getValue() == '-') {
            root = (((OpNode) lastAdded).getLeft());
            ((OpNode) lastAdded).setLeft(null);
            root.setFather(null);
            return true;
        }

        //then it's '*' or '/'

        OpNode op = (OpNode) lastAdded.getFather();
        if (op != null) {
            op.setRight(((OpNode)lastAdded).getLeft());
        }
        else {
            root = ((OpNode) lastAdded).getLeft();
        }
        ((OpNode) lastAdded).getLeft().setFather(op);

        lastAdded.setFather(null);
        ((OpNode) lastAdded).setLeft(null);

        return true;
        // TODO: refactor o nome da árvore

    }

}
