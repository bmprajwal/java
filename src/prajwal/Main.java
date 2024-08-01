package prajwal;

import java.util.Scanner;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 3;
        int M = 3;
        int X = 2;
        scanner.close();

        // DP table to store the count of sequences
        int[][] dp = new int[N + 1][1024];

        // There's exactly one way to have a sequence of length 0 with XOR 0: the empty sequence.
        dp[0][0] = 1;

        // Iterate over each position in the sequence
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 1024; j++) {
                for (int k = 0; k <= M; k++) {
                    dp[i][j ^ k] = (dp[i][j ^ k] + dp[i - 1][j]) % MOD;
                }
            }
        }

        // The result is the number of sequences of length N with XOR value X
        System.out.println(dp[N][X]);
    }
}
