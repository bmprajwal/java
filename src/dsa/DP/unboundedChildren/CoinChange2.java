package dsa.DP.unboundedChildren;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        System.out.println(coinChange2(coins, amount));
    }

    static int coinChange2(int[] coins, int amount){
        int n = coins.length;
        int[][] t = new int[n+1][amount+1];
        for (int i = 0; i <= amount; i++) {
            t[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i <= amount; i++) {
            if(i % coins[0] == 0){
                t[1][i] = i / coins[0];
            } else {
                t[1][i] = Integer.MAX_VALUE - 1;
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(1 + t[i][j-coins[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][amount] == Integer.MAX_VALUE - 1? -1: t[n][amount];
    }
}
