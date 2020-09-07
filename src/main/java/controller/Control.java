package controller;

import constants.KindNode;
import model.map.Area;
import model.Node;
import util.Movable;

import java.util.NoSuchElementException;

public class Control {
    private final Area location;

    public Control(Area location) {
        this.location = location;
    }

    public Movable<Node> go(int i, int j) {
        Node node = new Node(i, j, KindNode.CURSOR.value());
        location.updateNode(node, node, KindNode.CURSOR.value());
        return new Step(node);
    }

    public Area getLocation() {
        return location;
    }


    class Step implements Movable<Node> {
        private Node cursor;

        public Step(Node cursor) {
            this.cursor = cursor;
        }

        @Override
        public boolean hasNextJ() {
            return location.getLengthJ() > cursor.getJ() + 1;
        }

        @Override
        public boolean hasNextI() {
            return location.getLengthI() > cursor.getI() + 1;
        }

        @Override
        public boolean hasPreviousJ() {
            return 0 <= cursor.getJ() - 1;
        }

        @Override
        public boolean hasPreviousI() {
            return 0 <= cursor.getI() - 1;
        }

        @Override
        public Node nextJ() {
            if (!hasNextJ()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getI(), cursor.getJ()+1, KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        @Override
        public Node nextI() {
            if (!hasNextI()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getI()+1, cursor.getJ(), KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        @Override
        public Node previousJ() {
            if (!hasPreviousJ()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getI(), cursor.getJ()-1 , KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        @Override
        public Node previousI() {
            if (!hasPreviousI()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getI() -1, cursor.getJ(), KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        @Override
        public String toString() {
            return "(" + cursor.getI() + ", " + cursor.getJ() + ")";
        }
    }
}
