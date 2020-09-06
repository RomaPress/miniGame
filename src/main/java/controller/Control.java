package controller;

import constants.KindNode;
import model.Area;
import model.Node;
import util.Movable;

import java.util.NoSuchElementException;

public class Control {
    private Area location;

    public Control(Area location) {
        this.location = location;
    }

    public Movable<Node> go(int x, int y) {
        Node node = new Node(x, y, KindNode.CURSOR.value());
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
        public boolean hasNextX() {
            return location.getLengthX() > cursor.getX() + 1;
        }

        @Override
        public boolean hasNextY() {
            return location.getLengthY() > cursor.getY() + 1;
        }

        @Override
        public boolean hasPreviousX() {
            return 0 <= cursor.getX() - 1;
        }

        @Override
        public boolean hasPreviousY() {
            return 0 <= cursor.getY() - 1;
        }

        @Override
        public Node nextX() {
            if (!hasNextX()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getX() + 1, cursor.getY(), KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        @Override
        public Node nextY() {
            if (!hasNextY()) {
                throw new NoSuchElementException();
            }
            int q = cursor.getX();
            int w = cursor.getY();
            Node newNode = new Node(cursor.getX(), cursor.getY() + 1, KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        @Override
        public Node previousX() {
            if (!hasPreviousX()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getX()- 1, cursor.getY() , KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        @Override
        public Node previousY() {
            if (!hasPreviousY()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getX() , cursor.getY()- 1, KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        @Override
        public String toString() {
            return "(" + cursor.getX() + ", " + cursor.getY() + ")" + cursor.getKind();
        }
    }
}
