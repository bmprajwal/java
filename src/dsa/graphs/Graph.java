package dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void insert(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
//        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 4));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

//        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));


    }

    static void bfs(ArrayList<Edge>[] graph, boolean[] vis, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void printAllPaths(ArrayList<Edge>[] graph,boolean[] vis, int curr ,String path, int target){
        if(curr == target){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                printAllPaths(graph, vis, e.dest, path+e.dest, target);
                vis[curr] = false;
            }
        }
    }

    public static boolean isCycleDirectedUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] recStack){
        vis[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(recStack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleDirectedUtil(graph, vis, e.dest, recStack)){
                return true;
            }
        }
        recStack[curr] = false;
        return false;
    }

    public static boolean isCycleDirected(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < vis.length; i++) {
            boolean cyclic = isCycleDirectedUtil(graph, vis, i, new boolean[vis.length]);
            if(cyclic) return true;
        }
        return false;
    }

    public static void topoSortUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> stack){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topoSortUtil(graph, vis, e.dest, stack);
            }
        }
        stack.add(curr);
    }

    public static void topoSort(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]){
                topoSortUtil(graph, vis, i, stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean isCycleUndirected(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent){
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] && e.dest != parent){
                return true;
            }
            if(!vis[e.dest]){
                if(isCycleUndirected(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        /*
        *     1 -- 3
        *   /      |  \
        * 0        |    5 -- 6
        *   \      |  /
        *     2 -- 4
        */
        insert(graph);
        boolean[] vis = new boolean[V];
//        for (int i = 0; i < vis.length; i++) {
//            if(!vis[i]){
//                dfs(graph, i, vis);
//            }
//        }

//        int src = 5;
//        int target = 6;
//        printAllPaths(graph, vis, src, src+"", target);

//        System.out.println(isCycleDirected(graph));
//        topoSort(graph);
        System.out.println(isCycleUndirected(graph, vis, 0, -1));
    }
}
