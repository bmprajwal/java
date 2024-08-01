package dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {

    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

        public static List<Integer> eventualSafeNodes(int[][] graph) {
            int V = graph.length;
            List<Integer> ans = new ArrayList<>();
            ArrayList<Edge>[] g = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < V; i++) {

                for (int j = 0; j < graph[i].length; j++) {
                    g[i].add(new Edge(i, graph[i][j]));
                }
            }

            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];
            for (int i = 0; i < V; i++) {
                boolean cyclic = isCyclicDirected(g, visited, i, recStack);
                if (!cyclic) {
                    ans.add(i);
                }
            }

            return ans;
        }

        public static boolean isCyclicDirected(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] recStack){
            vis[curr] = true;
            recStack[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if(recStack[e.dest]){
                    return true;
                }
                if(!vis[e.dest] && isCyclicDirected(graph, vis, e.dest, recStack)){
                    return true;
                }
            }
            recStack[curr] = false;
            return false;
        }

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {2,3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }
}
