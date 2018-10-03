
public class OperationTree {

    public static void main(String[] args) {
        //main for tests, not supposed to be in the final codes
        String op="30+12";
        Node root = new Node();
        root = build_tree(op);
        test(root);
      //  int n =calcula_tree(root);
      //  System.out.println(n);
    }
    public static void test(Node root){
      System.out.println(root.getValue());
      System.out.println(root.getLeft().getValue());
      System.out.println(root.getRight().getValue());
    }
    /*
    public int insert(Node root, String key){

        if(key=="+" || key=="-"){
            //becomes the new root
            Node node = new Node();
            node.setLeft(root);
        }
        return 1;
    }*/
    public static Tree create_tree(){
        Tree tree = new Tree();
        tree.size=0;
        tree.setIgnoreRoot();
        return tree;
    }
    public static Node build_tree(String operations){
        int num=0;
        char[] op=operations.toCharArray();
        Tree tree = new Tree();
        tree = create_tree();
        Node simboloAnterior = new Node();
        Node numeroAnterior = new Node();
        Node aux = new Node();
        for(int i=0; i<operations.length(); i++){
            if(op[i]>=48 && op[i]<=57){
                //it's a number;
                num*=10;
                num+=op[i]-48;
                continue;
            }
            else if((op[i]<48 || op[i]>57) ||
                   ((op[i]>=48 && op[i]<=57) && op[i+1]=='\n')){
                //it's an operator so I must set the node with the number gathered
                final Node numberNode = new Node();
                numberNode.setValue(String.valueOf(num));
                num=0;
                if(tree.size==0){//becomes root
                    tree.root=numberNode;
                }
                else{
                    simboloAnterior.setRight(numberNode);
                    numberNode.setFather(simboloAnterior);
                }
                numeroAnterior = numberNode;
                tree.size++;
            }

            if(op[i]=='+' || op[i]=='-'){

                //operator becomes the root;

                Node node = new Node();
                node.setValue(String.valueOf(op[i]));

                tree.root.setFather(node);
                aux=tree.root;
                tree.root=node;
                tree.root.setLeft(aux);
                tree.size++;
                simboloAnterior=node;
            }
            else{ //it's '*' or '/'
                Node node = new Node();
                node.setValue(String.valueOf(op[i]));
                if(numeroAnterior.getFather().getValue()=="+" || (numeroAnterior.getFather()).getValue()=="-"){

                    node.setFather(numeroAnterior.getFather());
                    node.setLeft(numeroAnterior);
                    numeroAnterior.getFather().setRight(node);
                    numeroAnterior.setFather(node);
                }
                else{
                    numeroAnterior.getFather().getFather().setRight(node);
                    node.setFather(numeroAnterior.getFather().getFather());
                    numeroAnterior.getFather().setFather(node);
                    node.setLeft(numeroAnterior.getFather());
                }
                simboloAnterior=node;
            }
        }
        return tree.root;
    }
    public static int calcula_tree(Node root){
        if(root.getValue()=="ignore"){
            return 0;
        }
        int x = 0,y = 0;
        char aux=root.getLeft().getValue().toCharArray()[0];
        if(aux!='+' && aux!='-' && aux!='*' && aux!='/'){
            //it's a number
            x=Integer.valueOf(root.getLeft().getValue());
        }
        else{
            x=calcula_tree(root.getLeft());
        }
        aux=root.getRight().getValue().toCharArray()[0];
        if(aux!='+' && aux!='-' && aux!='*' && aux!='/'){
            //it's a number
            y=Integer.valueOf(root.getRight().getValue());
        }
        else{
            y=calcula_tree(root.getRight());
        }
        if(root.getValue()=="+")
            return x+y;
        if(root.getValue()=="-")
            return x-y;
        if(root.getValue()=="*")
            return x*y;

        return x/y;
    }
}
