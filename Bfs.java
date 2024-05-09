import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    ArrayList<Integer>[] adjList;

    public Graph(int n, int[][] edges) {
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
    }

    public void printGraph() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Adjacency list of vertex " + i + ": ");
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class Bfs {
    public static void main(String[] args) {
        int[][] edges = {
            {1, 2}, {1, 3},{2, 4},{3, 5},
            {4, 6},{5, 6}
        };
        int numVertices = 7;

        Graph graph = new Graph(numVertices, edges);
        System.out.println("Printing Adjacency List of Given Graph:");
        graph.printGraph();

        System.out.println("\nBFS Traversal starting from vertex 1:");
        BFS(graph, 1);  // Start BFS traversal from vertex 1
    }

    public static void BFS(Graph graph, int start) {
        boolean[] visited = new boolean[graph.adjList.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int neighbor : graph.adjList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
