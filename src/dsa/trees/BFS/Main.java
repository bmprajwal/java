package dsa.trees.BFS;

import java.util.*;

public class Main {
    public void helper_function() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] edges = new int[N];
            for (int i = 0; i < N; i++) {
                edges[i] = sc.nextInt();
            }
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int result = leastCommonDescendent(edges, N, node1, node2);
            System.out.println(result);
        }
        sc.close();
    }

    public static int leastCommonDescendent(int[] nodes, int N, int node1, int node2) {
        int[] visited = new int[N];
        int cnt1 = 0;
        int cnt2 = 0;
        int mark = node1;

        if (node1 == node2) return node2;

        for (int i = 0; i < N; i++) {
            visited[i] = 0;
        }

        while ((nodes[node1] != node1) && (nodes[node1] != -1) && (visited[node1] == 0) && (node1 != node2)) {
            visited[node1]++;
            node1 = nodes[node1];
            cnt1++;
        }

        visited[node1]++;

        while ((nodes[node2] != node2) && (nodes[node2] != -1) && (visited[node2] != 2) && (node1 != node2)) {
            visited[node2]++;
            node2 = nodes[node2];
            cnt2++;
        }

        if (node1 != node2) return -1;
        if ((nodes[node1] == -1) && (visited[node2] == 1)) return -1;
        if (nodes[node2] == -1) return -1;

        if (cnt1 > cnt2)
            return node2;
        else
            return mark;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.helper_function();
    }
}