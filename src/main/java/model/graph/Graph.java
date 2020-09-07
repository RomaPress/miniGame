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
                    edges = new ArrayList<>(this.addNeighbour(area, i, j));
                    net.put(area.getArray()[i][j], edges);
                }
            }
        }
    }

    public List<Edge> addNeighbour(Area area, int i, int j) {
        List<Edge> edges = new ArrayList<>();
        Control control = new Control(area);
        Movable<Node> current = control.go(i, j);
        Node newNode;

        if (current.hasNextJ() && (!Node.isBlock(newNode = new Node(area.getRightNeighbour(i, j))))) {
            edges.add(new Edge(newNode));
        }
        if (current.hasPreviousJ() && (!Node.isBlock(newNode = new Node(area.getLeftNeighbour(i, j))))) {
            edges.add(new Edge(newNode));
        }
        if (current.hasNextI() && (!Node.isBlock(newNode = new Node(area.getUpperNeighbour(i, j))))) {
            edges.add(new Edge(newNode));
        }
        if (current.hasPreviousI() && (!Node.isBlock(newNode = new Node(area.getDownNeighbour(i, j))))) {
            edges.add(new Edge(newNode));
        }
        return edges;
    }

    public Map<Node, List<Edge>> getNet() {
        return net;
    }
}