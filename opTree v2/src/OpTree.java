public class OpTree extends Tree {
    private char value;

    public OpTree(char value) {
        this.value = value;
    }

    public void setValue(char value){
        this.value=value;
    }
    public char getValue(){
        return this.value;
    }
}
