package ro.amihaescu.algos;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Integer>> edges;
    private int size;

    Graph(int size) {
        this.size = size;
        edges = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            edges.add(i, new ArrayList());
        }
    }

    void addEdge(int col, int row) {
        edges.get(col).add(row);
        edges.get(row).add(col);
    }

    public List<List<Integer>> getEdges() {
        return edges;
    }

    public int getSize() {
        return size;
    }

    public List<Integer> neighbours(int node) {
        return edges.get(node);
    }

}

