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
        Node node =new Node(x, y, KindNode.CURSOR.value());
        location.updateNode(node,node,KindNode.CURSOR.value());
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

        public Node getCursor() {
            return cursor;
        }

        public void setCursor(Node cursor) {
            this.cursor = cursor;
        }

        public boolean hasNextX() {
            return location.getLengthX() > cursor.getX() + 1;
        }

        public boolean hasNextY() {
            return location.getLengthY() > cursor.getY() + 1;
        }

        public boolean hasPreviousX() {
            return 0 <= cursor.getX() - 1;
        }

        public boolean hasPreviousY() {
            return 0 <= cursor.getY() - 1;
        }

        public Node nextX() {
            if (!hasNextX()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getX() , cursor.getY()+1, KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        public Node nextY() {
            if (!hasNextY()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getX()+1 , cursor.getY(), KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        public Node previousX() {
            if (!hasPreviousX()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getX() , cursor.getY()-1, KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }

        public Node previousY() {
            if (!hasPreviousY()) {
                throw new NoSuchElementException();
            }
            Node newNode = new Node(cursor.getX()-1 , cursor.getY(), KindNode.CURSOR.value());
            location.updateNode(cursor, newNode, KindNode.CURSOR.value());
            cursor = newNode;
            return cursor;
        }
    }
}
