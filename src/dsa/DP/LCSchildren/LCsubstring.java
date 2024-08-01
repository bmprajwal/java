package dsa.DP.LCSchildren;

public class LCsubstring {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        System.out.println(lcSubstring(x, y, x.length(), y.length()));
    }
    static int lcSubstring(String a, String b, int m, int n){
        int[][] t = new int[m+1][n+1];
        int maxLength = 0;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                    maxLength = Math.max(maxLength, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return maxLength;
    }
}
