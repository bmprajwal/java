package dsa.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class CheapestFlight {

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        int stops;
        public Pair(int n, int d, int s){
            this.node = n;
            this.dist = d;
            this.stops = s;
        }
        @Override
        public int compareTo(Pair p2){
            return this.stops - p2.stops;
        }
    }

    public static void insert(int[][] flights, ArrayList<DijkstrasAlgo.Edge>[] graph, int V){
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new DijkstrasAlgo.Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    public static int dijstrasAlgo(ArrayList<DijkstrasAlgo.Edge>[] graph, int V, int src, int dst, int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(curr.stops > k){
                continue;
            }
            if(!vis[curr.node]){
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    DijkstrasAlgo.Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.dist < dist[v] && curr.stops <= k){
                        dist[v] = dist[u] + e.dist;
                        pq.add(new Pair(v, dist[v], curr.stops+1));
                    }
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<DijkstrasAlgo.Edge>[] graph = new ArrayList[n];
        insert(flights, graph, n);
        return dijstrasAlgo(graph, n, src, dst, k);
    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,1},{0,2,5}, {1,2,1}, {2,3, 1}};
        int src = 0;
        int dst = 3;
        int k = 1;
        int n = 4;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

}
