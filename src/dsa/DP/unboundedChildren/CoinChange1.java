package dsa.DP.unboundedChildren;

public class CoinChange1 {
    public static void main(String[] args) {
        int[] coin = {3};
        int sum = 2;
        System.out.println(coinChange1(coin, sum));
    }

    static int coinChange1(int[] coin, int sum){
        int n = coin.length;
        int[][] t = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(coin[i-1] <= j){
                    t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
