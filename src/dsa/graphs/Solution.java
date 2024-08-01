package dsa.graphs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void insert(ArrayList<Edge>[] graph, List<List<Integer>> connections, int V){
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            int src = connection.get(0);
            int dest = connection.get(1);
            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }
    }
    public static List<List<Integer>> getBridge(ArrayList<Edge>[] graph, int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(graph, i, vis, time, dt, low, -1, ans);
            }
        }
        return ans;
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis, int time, int[] dt, int[] low, int par, List<List<Integer>> ans){
        vis[curr] = true;
        List<Integer> bridge = new ArrayList();
        dt[curr] = low[curr] = ++time;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            } else if(!vis[e.dest]){
                dfs(graph, e.dest, vis, time, dt, low, curr, ans);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(dt[curr] < low[e.dest]){
                    bridge.add(curr);
                    bridge.add(e.dest);
                    ans.add(bridge);
                }
            } else{
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<>(List.of(0,1)));
//        connections.add(new ArrayList<>(List.of(1,2)));
//        connections.add(new ArrayList<>(List.of(2,0)));
//        connections.add(new ArrayList<>(List.of(1,3)));
        ArrayList<Edge>[] graph = new ArrayList[n];
        insert(graph, connections, n);
        List<List<Integer>> ans = getBridge(graph, n);
        for(List<Integer> l : ans){
            System.out.println(l);
        }
    }
}