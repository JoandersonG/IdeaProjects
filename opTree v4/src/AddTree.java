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

            ((ParenNode) lastAddedNode).addNo(number);
        }

        //then last added node is an operator

        NumNode node = new NumNode(number);
        node.setFather(lastAddedNode);
        ((OpNode) lastAddedNode).setRight(node);
    }

    public static void addNode(char operation) {

        if(isParenthesis && operation != ')') {
            ParenNode pn = (ParenNode) lastAddedNode;
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

        ParenNode pn = (ParenNode) lastAddedNode;

        if (pn.lastAddedNode().getValue() == '(') {

            // if last added node was a parenthesis and inside it the last added node as a parenthesis

            pn.addNo(')');
            return;
        }

        //then this is the last opened parenthesis

        isParenthesis = false;

    }

    private void addParenNode(ParenNode node) {
        //this.size++;
        if (root == null) {
            root = node;
            return;
        }

        ((OpNode)lastAddedNode).setRight(node);
    }

    private void addNumNode(NumNode node) {
        //todo: this.size++;
        if (root == null) {
            root = node;
            return;
        }

        // lastAddedNode is necessarily an OpNode

        ((OpNode)lastAddedNode).setRight(node);
    }

    private void addPlusSubNode(OpNode node) {

        //the way add and subtraction nodes work in the tree is similar to each other

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

    private void addDivideMultiNode(OpNode node) {
        //the way divide and multiplication nodes work in the tree is similar to each other
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