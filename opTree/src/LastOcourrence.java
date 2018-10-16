public class LastOcourrence {
    private Node root;
    private OpNode lastOpNode;
    private NumNode lastNumNode;
    private Node lastAddedNode;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public OpNode getLastOpNode() {
        return lastOpNode;
    }

    public void setLastOpNode(OpNode lastOpNode) {
        this.lastOpNode = lastOpNode;
    }

    public NumNode getLastNumNode() {
        return lastNumNode;
    }

    public void setLastNumNode(NumNode lastNumNode) {
        this.lastNumNode = lastNumNode;
    }

    public Node getLastAddedNode() {
        return lastAddedNode;
    }

    public void setLastAddedNode(Node lastAddedNode) {
        this.lastAddedNode = lastAddedNode;
    }
}
