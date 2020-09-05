package constants;

public enum KindNode {
    CURSOR('O'), BLOCK('#'), SIMPLE('_');

    private char value;

    KindNode(char value){
        this.value = value;
    }

    public char value() {
        return value;
    }
}
