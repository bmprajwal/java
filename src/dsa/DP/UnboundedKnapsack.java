package dsa.DP;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        // rod cutting example
        int[] length = {1,2,3,4,5};
        int[] price = {2,5,7,8,10};
        int N = 5;
        System.out.println(unboundedKnapsack(length, price, N, length.length));
    }

    static int unboundedKnapsack(int[] length, int[] price, int N, int n){
        int[][] t = new int[n+1][N+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) {
                if(length[i-1] <= j){
                    t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][N];
    }
}
