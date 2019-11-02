package ro.amihaescu.algos;

import java.util.List;

public class DFS {

    private Graph graph;
    private int[] connectedComponents;

    public DFS(Graph graph) {
        this.graph = graph;
        this.connectedComponents = new int[graph.getSize()];
    }

    void traverseGraph(int node) {
        traverseGraph(node, new boolean[graph.getSize()]);
    }

    private void traverseGraph(int node, boolean[] visited) {
        traverseGraph(node, visited, 0);
    }

    private void traverseGraph(int node, boolean[] visited, int componentCount) {
        visited[node] = true;
        connectedComponents[node] = componentCount;
        System.out.println("Visited " + node);
        List<Integer> nodeEdges = graph.getEdges().get(node);
        for (Integer edge : nodeEdges) {
            if (!visited[edge]) {
                traverseGraph(edge, visited, componentCount);
            }
        }
    }

    void connectedComponents() {
        boolean[] visited = new boolean[graph.getSize()];
        int componentCount = 0;
        for (int vertex = 0; vertex < graph.getSize(); vertex++) {
            if (!visited[vertex]) {
                traverseGraph(vertex, visited, componentCount);
                componentCount++;
            }
        }
        for (int index = 0; index < graph.getSize(); index++) {
            System.out.println(index + " belongs to component " + connectedComponents[index]);
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);
        DFS dfs = new DFS(graph);

        dfs.traverseGraph( 0);
        dfs.connectedComponents();
    }
}
