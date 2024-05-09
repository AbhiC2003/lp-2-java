import java.util.*;

class Graph {
    int V;
    ArrayList<Edge> graph;

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    Graph(int vertices) {
        V = vertices;
        graph = new ArrayList<>();
    }

    void addEdge(int u, int v, int w) {
        graph.add(new Edge(u, v, w));
    }

    int findParent(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return findParent(parent, parent[i]);
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int xroot = findParent(parent, x);
        int yroot = findParent(parent, y);

        if (rank[xroot] < rank[yroot])
            parent[xroot] = yroot;
        else if (rank[xroot] > rank[yroot])
            parent[yroot] = xroot;
        else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    void kruskalMST() {
        ArrayList<Edge> result = new ArrayList<>();

        Collections.sort(graph);

        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int e = 0;
        int i = 0;
        while (e < V - 1) {
            Edge nextEdge = graph.get(i);
            i++;

            int x = findParent(parent, nextEdge.src);
            int y = findParent(parent, nextEdge.dest);

            if (x != y) {
                e++;
                result.add(nextEdge);
                union(parent, rank, x, y);
            }
        }

        System.out.println("Edges in the minimum spanning tree:");
        for (Edge edge : result) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}

public class Kruskal {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 8);
        g.addEdge(2, 4, 10);
        g.addEdge(3, 4, 2);
        g.addEdge(3, 5, 6);
        g.addEdge(4, 5, 3);

        g.kruskalMST();
    }
}
