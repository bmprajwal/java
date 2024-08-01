package dsa.DP.LCSchildren;

public class LCSprint {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        lcsTopdown(x, y, x.length(), y.length());
    }

    static void lcsTopdown(String x, String y, int m, int n){
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

        int i = m;
        int j = n;
        StringBuilder str = new StringBuilder();
        while (i>0 && j>0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                str.append(x.charAt(i-1));
                i--;
                j--;
            } else {
                if(t[i][j-1] > t[i-1][j]){
                    j--;
                } else {
                    i--;
                }
            }
        }
        System.out.println(str.reverse());
    }
}
