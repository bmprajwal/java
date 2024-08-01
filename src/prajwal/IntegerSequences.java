package prajwal;

import java.util.*;

public class IntegerSequences {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 200;
        int M = 900606388;
        int X = 317329110;

        int result = countSequences(N, M, X);
        System.out.println(result);
    }

    public static int countSequences(int N, int M, int X) {
        int[][] dp = new int[N + 1][M + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= M; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j ^ k]) % MOD;
                }
            }
        }

        return dp[N][X];
    }
}
