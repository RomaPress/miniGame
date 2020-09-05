package model;

public class Node {
    private int x;
    private int y;
    private char kind;

    public Node(int x, int y, char kind) {
        this.x = x;
        this.y = y;
        this.kind = kind;
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
