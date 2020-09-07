package model.map;

import constants.KindNode;
import model.Node;

public class Area {
    private Node[][] array;
    private final int lengthX;
    private final int lengthY;

    public Area(int lengthX, int lengthY) {
        this.lengthX = lengthX;
        this.lengthY = lengthY;

        array = new Node[lengthX][lengthY];
        for (int i = 0; i < lengthY; i++) {
            for (int j = 0; j < lengthX; j++) {
                array[i][j] = new Node(j, lengthY - i - 1, KindNode.SIMPLE.value());
            }
        }
    }

    public void updateNode(Node oldNode, Node newNode, char kind) {
        array[lengthY - 1 - oldNode.getY()][oldNode.getX()].setKind(KindNode.SIMPLE.value());
        array[lengthY - 1 - newNode.getY()][newNode.getX()].setKind(kind);
    }

    public Node getLeftNeighbor(int i, int j){
        return array[i][j-1];
    }

    public Node getRightNeighbor(int i, int j){
        return array[i][j+1];
    }

    public Node getUpperNeighbor(int i, int j){
        return array[i+1][j];
    }

    public Node getDownNeighbor(int i, int j){
        return array[i-1][j];
    }

    public Node[][] getArray() {
        return array;
    }

    public void setArray(Node[][] array) {
        this.array = array;
    }

    public int getLengthX() {
        return lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lengthY; i++) {
            for (int j = 0; j < lengthX; j++) {
                stringBuilder.append(    array[i][j].getKind());
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
