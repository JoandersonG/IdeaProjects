public class mainTest {

    public static void main(String[] args) {
        OperationTree op = new OperationTree();

        op.addNode(3);
        op.addNode('+');
        op.addNode(5);
        op.addNode('*');
        op.addNode(10);

        System.out.println(op.calculateTree());
    }
}
