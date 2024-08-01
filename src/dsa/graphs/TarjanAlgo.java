package dsa.graphs;

import java.util.ArrayList;

public class TarjanAlgo {
    public static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void insert(ArrayList<Edge>[] graph, int V){
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }
    public static void getBridge(ArrayList<Edge>[] graph, int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs(graph, i, -1, vis, time, dt, low);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, boolean[] vis, int time, int[] dt, int[] low){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == par){
                continue;
            } else if(vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else{
                dfs(graph, neigh, curr, vis, time, dt, low);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr] < low[neigh]){
                    System.out.println(curr + " " + neigh);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        insert(graph, V);
        getBridge(graph, V);
    }
}
