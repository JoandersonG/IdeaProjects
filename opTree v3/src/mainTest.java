public class mainTest {

    public static void main(String[] args) {
        OperationTree op = new OperationTree();

    //    op.addNode('(');
     //   op.addNode('(');
        op.addNode('(');
        op.addNode(3);
        op.addNode('+');
     //   op.addNode('(');
        op.addNode(5);
        op.addNode(')');
       op.addNode('*');
       // op.addNode('(');
        op.addNode(10);
     //   op.addNode(')');
           op.addNode('+');
        op.addNode(5);
    //    op.addNode('(');
     //   op.addNode(')');
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
       // op.removeLastAddedNode();
        //op.removeLastAddedNode();
     //   op.removeLastAddedNode();
   //     op.removeLastAddedNode();

    // ((3+5)*10)*5
        System.out.println(op.calculateTree());
    }
}