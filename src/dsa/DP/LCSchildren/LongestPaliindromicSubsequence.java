package dsa.DP.LCSchildren;

public class LongestPaliindromicSubsequence {
    public static void main(String[] args) {
        String a = "agbcba";
        System.out.println(LPS(a));
    }

    static int LPS(String a){
        return LCS(a, new StringBuilder(a).reverse().toString());
    }

    static int LCS(String x, String y){
        int m = x.length();
        int n = y.length();

        if(m == 0 || n == 0){
            return 0;
        }
        int[][] t = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[m][n];
    }
}
