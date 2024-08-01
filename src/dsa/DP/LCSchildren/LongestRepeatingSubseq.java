package dsa.DP.LCSchildren;

public class LongestRepeatingSubseq {
    public static void main(String[] args) {
        String s = "aabebcdd";
        System.out.println(LRS(s));
    }

    static int LRS(String x){
        int m = x.length();
        int n = x.length();
        int[][] t = new int[m+1][n+1];
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(x.charAt(i-1) == x.charAt(j-1) && i!=j){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[m][n];
    }
}
