package dsa.DP;

public class KnapSack {
    static int maxN = 10;
    static int maxW = 50;
    static int[][] t = new int[maxN + 1][maxW + 1];
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int W = 7;

        // initalization for memoization
//        for (int i = 0; i < maxN; i++) {
//            for (int j = 0; j < maxW; j++) {
//                t[i][j] = -1;
//            }
//        }

        // initialization for top down
//        for (int i = 0; i < maxN + 1; i++) {
//            for (int j = 0; j < maxW + 1; j++) {
//                if(i == 0 || j == 0){
//                    t[i][j] = 0;
//                }
//            }
//        }

        System.out.println(knapsackTopDown(wt, val, W, 4));
    }


    // knapsack recursive
    static int knapsackMemoized(int[] wt, int[] val, int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }
        if(t[n][W] != -1){
            return t[n][W];
        }

        if(wt[n-1] <= W){
            return t[n][W] = Math.max(val[n-1] + knapsackMemoized(wt, val, W - wt[n-1], n - 1), knapsackMemoized(wt,val, W, n-1));
        } else {
            return t[n][W] = knapsackMemoized(wt, val, W, n-1);
        }
    }

    static int knapsack(int[] wt, int[] val, int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }

        if(wt[n-1] <= W){
            return Math.max(val[n-1] + knapsack(wt, val, W - wt[n-1], n - 1), knapsack(wt,val, W, n-1));
        } else {
            return knapsack(wt, val, W, n-1);
        }
    }

    static int knapsackTopDown(int[] wt, int[] val, int W, int n){
        int[][] t = new int[n+1][W+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if(wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }


        int i = n;
        int j = W;
        while(i > 0 && j > 0){
            if(t[i][j] != t[i-1][j]){
                System.out.println(i - 1 + " " + wt[i - 1]);
                j = j - wt[i - 1];
            }
            i--;
        }

        return t[n][W];
    }
}
