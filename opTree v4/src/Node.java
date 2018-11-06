/**
 * Created by joanderson on 12/08/18.
 */

public abstract class Node{

    private Node father;
    protected final char value;
    // for number nodes value = 'n';
    // for operation nodes (+,-,*,/) value = the operator
    // for parenthesis value = '('

    Node(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }
}
