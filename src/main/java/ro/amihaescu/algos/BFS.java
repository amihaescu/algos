package ro.amihaescu.algos;

import java.util.*;
import java.util.stream.Collectors;

public class BFS {

    private Graph graph;
    private Map<Integer, Integer> prev;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    private void traverse(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        prev = new LinkedHashMap<>();
        queue.add(node);
        boolean[] visited = new boolean[graph.getSize()];
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();
            List<Integer> neighbours = this.graph.neighbours(node);

            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    prev.put(neighbour, node);
                }
            }
        }
    }

    private String reconstructPath(int startingNode, int endNode) {
        traverse(startingNode);
        List<Integer> path = new ArrayList<>();

        for (Integer node = endNode; node != null; node = prev.get(node)) {
            path.add(node);
        }

        Collections.reverse(path);
        if (path.get(0).equals(startingNode)) {
            return "Nodes connected: " +
                    path.stream().map(integer -> integer + "").collect(Collectors.joining(" "));

        } else {
            return "Nodes not connected";
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.addEdge(3, 5);
        graph.addEdge(1, 6);
        graph.addEdge(2, 4);

        graph.addEdge(6, 9);
        graph.addEdge(6, 8);
        graph.addEdge(4, 7);
        BFS bfs = new BFS(graph);
        bfs.traverse(0);
        System.out.println(bfs.reconstructPath(3, 7));
    }

}
