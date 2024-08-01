package prajwal;

import java.util.Arrays;
import java.util.List;

public class KnapsackProblemWithTwist {

    public static long getMinimumCost(List<Integer> cost, int minWeight) {
        int n = cost.size();
        
        // Define a very large value representing infinity
        long INF = Long.MAX_VALUE / 2;
        
        // Upper bound for the weight we need to consider
        int maxWeight = (1 << n) - 1;
        if (minWeight > maxWeight) return -1;  // If minWeight is more than the maximum possible weight

        // DP array to store the minimum cost for each weight
        long[] dp = new long[minWeight + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;  // No cost to achieve weight 0

        // Iterate over each item
        for (int i = 0; i < n; i++) {
            int weight = 1 << i;  // weight of the i-th item is 2^i
            for (int w = minWeight; w >= weight; w--) {
                if (dp[w - weight] != INF) {
                    dp[w] = Math.min(dp[w], dp[w - weight] + cost.get(i));
                }
            }
        }

        // Find the minimum cost to achieve at least minWeight
        long minCost = dp[minWeight];

        // If it's still INF, it means we couldn't achieve the weight
        return (minCost == INF) ? -1 : minCost;
    }

    public static void main(String[] args) {
        List<Integer> cost = Arrays.asList(2, 5, 7, 11, 25);
        int minWeight = 26;
        System.out.println(getMinimumCost(cost, minWeight));  // Expected output: 37
    }
}