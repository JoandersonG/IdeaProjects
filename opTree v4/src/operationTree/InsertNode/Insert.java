package operationTree.InsertNode;
import operationTree.Node;
import operationTree.NumNode;
import operationTree.OpNode;
import operationTree.ParenNode;

public class Insert {
    private Insert() {
        // to prevent instanciability
    }
    public Node addNode(double number, Boolean isParenthesis, Node lastAddedNode, Node root) {
        if (isParenthesis) {

            //last added node is a parenthesis

            ((ParenNode) lastAddedNode).addNo(number);
            return root;
        }

        NumNode node = new NumNode(number);

        if (lastAddedNode == null) {
            root = node;
            return root;
        }

        //then last added node is an operator

        node.setFather(lastAddedNode);
        ((OpNode) lastAddedNode).setRight(node);
        return root;
    }

    public Node addNode(char operation, Boolean isParenthesis, Node lastAddedNode, Node root) {

        if(isParenthesis && operation != ')') {
            ParenNode pn = (ParenNode) lastAddedNode;
            pn.addNo(operation);
            return root;
        }

        if (operation == '(') {
            ParenNode pn = new ParenNode();
            root = addParenNode(pn);
            isParenthesis = true;
            return root;
        }

        if (operation == '+' || operation == '-') {
            OpNode op = new OpNode(operation);
            root = addPlusSubNode(op);
            return root;
        }

        if (operation == '*' || operation == '/') {
            OpNode op = new OpNode(operation);
            root = addDivideMultiNode(op);
            return root;
        }

        //it's a parenthesis closure

        ParenNode pn = (ParenNode) lastAddedNode;

        if (pn.lastAddedNode().getValue() == '(') {

            // if last added node was a parenthesis and inside it the last added node as a parenthesis

            pn.addNo(')');
            return root;
        }

        //then this is the last opened parenthesis

        isParenthesis = false;
        return root;
    }

    private Node addParenNode(ParenNode node, Node root) {
        //todo: this.size++;
        if (root == null) {
            root = node;
            return root;
        }

        // lastAddedNode is necessarily an operationTree.OpNode
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

        // lastAddedNode is necessarily an operationTree.OpNode
        OpNode last = (OpNode) lastAddedNode();
        last.setRight(node);
        node.setFather(last);
    }

    private void addPlusSubNode(OpNode node) {

        //the way add and subtraction operationTree.nodes work in the tree is similar to each other

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
        //the way divide and multiplication operationTree.nodes work in the tree is similar to each other
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

}
