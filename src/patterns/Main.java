package patterns;

import java.util.*;

public class Main {
    public void helper_function() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            List<Integer> edges = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                edges.add(sc.nextInt());
            }
            int result = findLargestSumCycle(edges);
            System.out.println(result);
        }
        sc.close();
    }

    // Function to find the largest sum cycle
    public static int findLargestSumCycle(List<Integer> edges) {
        int n = edges.size();
        int[] visited = new int[n];
        int[] pathSum = new int[n];
        int maxSumCycle = -1;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                maxSumCycle = Math.max(maxSumCycle, dfs(i, edges, visited, pathSum, 0));
            }
        }

        return maxSumCycle;
    }

    // Depth-First Search to detect cycles and calculate their sums
    private static int dfs(int node, List<Integer> edges, int[] visited, int[] pathSum, int currentSum) {
        if (node == -1) return -1;
        if (visited[node] == 1) return currentSum - pathSum[node];
        if (visited[node] == 2) return -1;

        visited[node] = 1;
        pathSum[node] = currentSum;

        int nextNode = edges.get(node);
        int cycleSum = dfs(nextNode, edges, visited, pathSum, currentSum + node);

        visited[node] = 2;

        return cycleSum;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.helper_function();
    }
}
