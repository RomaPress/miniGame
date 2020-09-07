package model;

import constants.KindNode;

public class Node {
    private int i;
    private int j;
    private char kind;

    public Node(int i, int j, char kind) {
        this.i = i;
        this.j = j;
        this.kind = kind;
    }

    public Node(Node anyNode) {
        this.i = anyNode.getI();
        this.j = anyNode.getJ();
        this.kind = anyNode.getKind();
    }

    public static boolean isBlock(Node node){
        return node.getKind() == KindNode.BLOCK.value();
    }

    public static boolean isCursor(Node node){
        return node.getKind() == KindNode.CURSOR.value();
    }

    public static boolean isSimple(Node node){
        return node.getKind() == KindNode.SIMPLE.value();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public char getKind() {
        return kind;
    }

    public void setKind(char kind) {
        this.kind = kind;
    }
}
