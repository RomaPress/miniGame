package constants;

public enum KindNode {
    CURSOR('0'), BLOCK('#'), SIMPLE('-');

    private final char value;

    KindNode(char value){
        this.value = value;
    }

    public char value() {
        return value;
    }
}
