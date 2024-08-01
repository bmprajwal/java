package dsa.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedule {

    public static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        int V = numCourses;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: prerequisites){
            graph[edge[1]].add(new Edge(edge[1], edge[0]));
        }

        boolean[] vis = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if(isCycleDirectedUtil(graph, vis, i, recStack)){
                    return false;
                }
            }
        }

        return true;

    }


    public static boolean isCycleDirectedUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] recStack) {
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

    public static void main(String[] args) {
        int[][] prerequisites = {{1,4}, {2,4},{3,1},{3,2}};
//        int[][] prerequisites = {{1,0}, {0,1}};
        int numCourses = 5;
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
