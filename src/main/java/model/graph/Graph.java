package model.graph;

import controller.Control;
import model.Node;
import model.map.Area;
import util.Movable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Node, List<Edge>> net;

    public Graph(Area area) {
        this.net = new HashMap<>();
        List<Edge> edges;
        for (int i = 0; i < area.getArray().length; i++) {
            for (int j = 0; j < area.getArray()[0].length; j++) {
                if (!Node.isBlock(area.getArray()[i][j])) {
                    edges = new ArrayList<>(this.addNeighbor(area, i, j));
                    net.put(area.getArray()[i][j], edges);
                }
            }
        }
    }

    public List<Edge> addNeighbor(Area area, int i, int j) {
        List<Edge> edges = new ArrayList<>();
        Control control = new Control(area);
        Movable<Node> current = control.go(i, j);
        Node newNode;


        if (current.hasNextX() && (!Node.isBlock(newNode = new Node(area.getRightNeighbor(i, j))))) {
            edges.add(new Edge(newNode));
        }
        if (current.hasPreviousX() && (!Node.isBlock(newNode = new Node(area.getLeftNeighbor(i, j))))) {
            edges.add(new Edge(newNode));
        }
        if (current.hasNextY() && (!Node.isBlock(newNode = new Node(area.getUpperNeighbor(i, j))))) {
            edges.add(new Edge(newNode));
        }
        if (current.hasPreviousY() && (!Node.isBlock(newNode = new Node(area.getDownNeighbor(i, j))))) {
            edges.add(new Edge(newNode));
        }

        System.err.println(edges);
        return edges;
    }

    public Map<Node, List<Edge>> getNet() {
        return net;
    }

    public static void main(String[] args) {
        Graph Q = new Graph(new Area(3,3));
    }
}