package model.map;

import constants.KindNode;
import model.Node;

public class Area {
    private Node[][] array;
    private final int lengthI;
    private final int lengthJ;

    public Area(int lengthI, int lengthJ) {
        this.lengthI = lengthI;
        this.lengthJ = lengthJ;

        array = new Node[lengthI][lengthJ];

        for (int i = 0; i < lengthI; i++) {
            for (int j = 0; j < lengthJ; j++) {
                array[i][j] = new Node(i, j, KindNode.SIMPLE.value());
            }
        }
    }

    public void updateNode(Node oldNode, Node newNode, char kind) {
        array[oldNode.getI()][oldNode.getJ()].setKind(KindNode.SIMPLE.value());
        array[newNode.getI()][newNode.getJ()].setKind(kind);
    }

    public Node getLeftNeighbour(int i, int j) {
        return array[i][j - 1];
    }

    public Node getRightNeighbour(int i, int j) {
        return array[i][j + 1];
    }

    public Node getUpperNeighbour(int i, int j) {
        return array[i + 1][j];
    }

    public Node getDownNeighbour(int i, int j) {
        return array[i - 1][j];
    }

    public Node[][] getArray() {
        return array;
    }

    public void setArray(Node[][] array) {
        this.array = array;
    }

    public int getLengthI() {
        return lengthI;
    }

    public int getLengthJ() {
        return lengthJ;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lengthI; i++) {
            for (int j = 0; j < lengthJ; j++) {
                stringBuilder.append(array[i][j].getKind());
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
