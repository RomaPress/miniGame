package model;

import constants.KindNode;

public class Node {
    private int x;
    private int y;
    private char kind;

    public Node(int x, int y, char kind) {
        this.x = x;
        this.y = y;
        this.kind = kind;
    }

    public Node(Node anyNode) {
        this.x = anyNode.getX();
        this.y = anyNode.getY();
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getKind() {
        return kind;
    }

    public void setKind(char kind) {
        this.kind = kind;
    }
}
