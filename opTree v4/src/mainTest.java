import operationTree.Tree;

public class mainTest {

    public static void main(String[] args) {
        Tree op = new Tree();

    //    op.addNode('(');
     //   op.addNode('(');
     //   op.addNode('(');
        op.addNode(3);
        op.addNode('*');
        op.addNode('(');
        op.addNode(5);
        //op.addNode(')');
       op.addNode('+');
       // op.addNode('(');
        op.addNode(10);
       op.addNode(')');
   //     op.addNode(')');
       op.addNode('*');
        op.addNode(5);
    //    op.addNode('+');
      //  op.addNode('(');
     //
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        op.removeLastAddedNode();
        asa

    // ((3+5)*10)*5
        System.out.println(op.calculateTree());
    }
}