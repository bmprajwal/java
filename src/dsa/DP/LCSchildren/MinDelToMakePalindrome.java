package dsa.DP.LCSchildren;

public class MinDelToMakePalindrome {
    public static void main(String[] args) {
        String s = "agbcba";
        System.out.println(minDel(s));
    }

    public static int minDel(String x){
        String y = new StringBuilder(x).reverse().toString();
        int m = x.length();
        int n = y.length();

        int[][] t = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return m - t[m][n];
    }
}
