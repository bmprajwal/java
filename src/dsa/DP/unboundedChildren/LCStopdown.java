package dsa.DP.unboundedChildren;

public class LCStopdown {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        System.out.println(lcsTopdown(x, y, x.length(), y.length()));;
    }

    static int lcsTopdown(String x, String y, int m, int n){
        int[][] t = new int[m+1][n+1];

        // initialization of row1 and col1 to 0 is not required as by default its 0

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
