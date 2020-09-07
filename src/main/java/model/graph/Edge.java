package model.graph;

import model.Node;

import java.util.Comparator;

public class Edge implements Comparator<Edge> {
    private final int weight;
    private Node destination;

    public Edge(Node destination) {
        this.weight = 1;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.getWeight() - o2.getWeight();
    }

    @Override
    public String toString() {
        return "EdgeTo = " + '(' + destination.getX() + ", " + destination.getY() + ')';
    }
}
