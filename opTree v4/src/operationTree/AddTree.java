package operationTree;

public class AddTree {

    static Node root;
    static Boolean isParenthesis;
    static Node lastAddedNode;

    private AddTree() {
        //to enforce noninstantiability
        throw new AssertionError();
    }

    /*

    public static void addNode(double number) {
        if (isParenthesis) {

            //last added node is a parenthesis

            ((operationTree.ParenNode) lastAddedNode).addNo(number);
        }

        //then last added node is an operator

        operationTree.NumNode node = new operationTree.NumNode(number);
        node.setFather(lastAddedNode);
        ((operationTree.OpNode) lastAddedNode).setRight(node);
    }

    public static void addNode(char operation) {

        if(isParenthesis && operation != ')') {
            operationTree.ParenNode pn = (operationTree.ParenNode) lastAddedNode;
            pn.addNo(operation);
            return;
        }

        if (operation == '(') {
            operationTree.ParenNode pn = new operationTree.ParenNode();
            addParenNode(pn);
            isParenthesis = true;
            return;
        }

        if (operation == '+' || operation == '-') {
            operationTree.OpNode op = new operationTree.OpNode(operation);
            addPlusSubNode(op);
            return;
        }

        if (operation == '*' || operation == '/') {
            operationTree.OpNode op = new operationTree.OpNode(operation);
            addDivideMultiNode(op);
            return;
        }

        //it's a parenthesis closure

        operationTree.ParenNode pn = (operationTree.ParenNode) lastAddedNode;

        if (pn.lastAddedNode().getValue() == '(') {

            // if last added node was a parenthesis and inside it the last added node as a parenthesis

            pn.addNo(')');
            return;
        }

        //then this is the last opened parenthesis

        isParenthesis = false;

    }

    private void addParenNode(operationTree.ParenNode node) {
        //this.size++;
        if (root == null) {
            root = node;
            return;
        }

        ((operationTree.OpNode)lastAddedNode).setRight(node);
    }

    private void addNumNode(operationTree.NumNode node) {
        //todo: this.size++;
        if (root == null) {
            root = node;
            return;
        }

        // lastAddedNode is necessarily an operationTree.OpNode

        ((operationTree.OpNode)lastAddedNode).setRight(node);
    }

    private void addPlusSubNode(operationTree.OpNode node) {

        //the way add and subtraction operationTree.nodes work in the tree is similar to each other

        //this.size++;
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

    private void addDivideMultiNode(operationTree.OpNode node) {
        //the way divide and multiplication operationTree.nodes work in the tree is similar to each other
        //this.size++;
        if (root == null) {
            root = node;
            return;
        }

        //last added node is a number

        node.setFather(lastAddedNode.getFather());
        lastAddedNode.setFather(node);
        node.setLeft(lastAddedNode);

    }
    */

}