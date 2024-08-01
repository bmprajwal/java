package dsa.graphs;

import java.util.ArrayList;

public class ArticulationPoint {
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
        graph[0].add(new Edge(0,6));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,6));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[6].add(new Edge(6,0));
        graph[6].add(new Edge(6,3));
        graph[6].add(new Edge(6,7));
        graph[6].add(new Edge(6,8));
        graph[7].add(new Edge(7,6));
        graph[7].add(new Edge(7,8));
        graph[8].add(new Edge(8,6));
        graph[8].add(new Edge(8,7));
    }

    public static void getAP(ArrayList<Edge>[] graph, int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs(graph, i, vis, time, dt, low, -1, ap);
            }
        }
        for (int i = 0; i < V; i++) {
            if(ap[i]){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis, int time, int[] dt, int[] low, int par, boolean[] ap) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == par){
                continue;
            } else if(vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, neigh, vis, time, dt, low, curr, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr] <= low[neigh] && par != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1  && children > 1){
            ap[curr] = true;
        }
    }

    public static void main(String[] args) {
        int V = 9;
        ArrayList<Edge>[] graph = new ArrayList[V];
        insert(graph, V);
        getAP(graph, V);
    }
}
