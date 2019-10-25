package ro.amihaescu.algos;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);

        graph.traverseGraph(0);
        graph.connectedComponents();
    }
}

class Graph {
    private List<List<Integer>> edges;
    private int[] connectedComponents;
    private int size;

    Graph(int size) {
        this.size = size;
        connectedComponents = new int[size];
        edges = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            edges.add(i, new ArrayList());
        }
    }

    void addEdge(int col, int row) {
        edges.get(col).add(row);
        edges.get(row).add(col);
    }

    void traverseGraph(int node) {
        traverseGraph(node, new boolean[this.size]);
    }

    private void traverseGraph(int node, boolean[] visited) {
        traverseGraph(node, visited, 0);
    }

    private void traverseGraph(int node, boolean[] visited, int componentCount) {
        visited[node] = true;
        connectedComponents[node] = componentCount;
        System.out.println("Visited " + node);
        List<Integer> nodeEdges = edges.get(node);
        for (Integer edge : nodeEdges) {
            if (!visited[edge]) {
                traverseGraph(edge, visited, componentCount);
            }
        }
    }

    void connectedComponents() {
        boolean[] visited = new boolean[this.size];
        int componentCount = 0;
        for (int vertex = 0; vertex < this.size; vertex++) {
            if (!visited[vertex]) {
                traverseGraph(vertex, visited, componentCount);
                componentCount++;
            }
        }
        for (int index = 0; index < this.size; index++) {
            System.out.println(index + " belongs to component " + connectedComponents[index]);
        }
    }
}
