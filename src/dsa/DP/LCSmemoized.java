package dsa.DP;

public class LCSmemoized {
    static int[][] t = new int[101][101];

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                t[i][j] = -1;
            }
        }
        String x = "abcdgh";
        String y = "abedfhr";
        System.out.println(lcsMemoized(x, y, x.length(), y.length()));;
    }
    static int lcsMemoized(String x, String y, int m, int n){
        if(m==0 || n==0){
            return 0;
        }
        if(t[m][n] != -1){
            return t[m][n];
        }

        if(x.charAt(m-1) == y.charAt(n-1)){
            return t[m][n] = 1 + lcsMemoized(x, y, m-1, n-1);
        } else {
            return t[m][n] = Math.max(lcsMemoized(x, y, m,n-1), lcsMemoized(x,y,m-1,n));
        }
    }
}
