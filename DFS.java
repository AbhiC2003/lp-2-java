import java.util.ArrayList;

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

    public void DFS(int v, boolean[] discovered, ArrayList<Integer> result) {
        discovered[v] = true;
        result.add(v);

        for (int u : adjList[v]) {
            if (!discovered[u]) {
                DFS(u, discovered, result);
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        int[][] edges = {
            {1, 2}, {1, 3},{2, 4},{3, 5},
            {4, 6},{5, 6}
        };
        int n = 7; // Adjust the value of n to match the maximum vertex index in the edges

        Graph graph = new Graph(n, edges);
        boolean[] discovered = new boolean[n];

        ArrayList<Integer> result = new ArrayList<>();
        int startVertex = 1;
        graph.DFS(startVertex, discovered, result);

        for (int vertex : result) {
            System.out.print(vertex + " ");
        }
    }
}
