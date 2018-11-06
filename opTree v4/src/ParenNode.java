public class ParenNode extends Node {

    private Tree subTree;

    public ParenNode() {
        super('(');
        subTree = new Tree();
    }

    public char getValue(){
        return super.value;
    }

    public double resultado() {
        return subTree.calculateTree();
    }

    public void addNo(double key) {
        subTree.addNode(key);
    }

    public void addNo(char key) {
        subTree.addNode(key);
    }

    public Node lastAddedNode() {
        return subTree.lastAddedNode();
    }

    public boolean removerUltimoNo() {
        return subTree.removeLastAddedNode();
    }

    public boolean isEmpty() {
        return subTree.isEmpty();
    }
}
