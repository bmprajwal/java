package dsa.graphs;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

public class BellmanFord {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static void insert(ArrayList<Edge>[] graph, int V){
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src, int V){
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int k = 0; k < V - 1; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }

//        for (int i = 0; i < V; i++) {
//            for (int j = 0; j < graph[i].size(); j++) {
//                Edge e = graph[i].get(j);
//                int u = e.src;
//                int v = e.dest;
//                if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]){
//                    System.out.println("negative weight cycle");
//                }
//            }
//        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        insert(graph, V);
        bellmanFord(graph, 0, V);
    }
}
