package ro.amihaescu.algos;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BFS {

    private Graph graph;
    private Queue<Integer> queue = new ArrayDeque<>();
    int[] prev;

    public BFS(Graph graph) {
        this.graph = graph;
        prev = new int[graph.getSize()];
    }

    private void traverse(int node) {
        queue.add(node);
        boolean[] visited = new boolean[graph.getSize()];
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();
            List<Integer> neighbours = this.graph.neighbours(node);

            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    System.out.print(neighbour + " ");
                    visited[neighbour] = true;
                    prev[neighbour] = node;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0,3);
        graph.addEdge(0,1);
        graph.addEdge(0,2);

        graph.addEdge(3,5);
        graph.addEdge(1,6);
        graph.addEdge(2,4);

        graph.addEdge(6,9);
        graph.addEdge(6,8);
        graph.addEdge(4,7);
        BFS bfs = new BFS(graph);
        bfs.traverse(0);
    }

}
