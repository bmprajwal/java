package dsa.DP.LCSchildren;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXYAB";

        int m = x.length();
        int n = y.length();
        System.out.println(m+n - lcs(x, y, x.length(), y.length()));
        System.out.println(scs(x, y));
    }
    static int lcs(String x, String y, int m, int n){
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
    public static String scs(String x, String y) {
        String str = lcsprint(x, y, x.length(), y.length());
        String ans = "";
        int p1=0, p2=0;

        for(char c: str.toCharArray()){
            while(p1 < x.length() && x.charAt(p1) != c){
                ans += x.charAt(p1++);
            }
            while(p2 < y.length() && y.charAt(p2) != c){
                ans += y.charAt(p2++);
            }
            ans += c;
            p1++;
            p2++;
        }
        if(p1 < x.length()){
            ans += x.substring(p1);
        }
        if(p2 < y.length()){
            ans += y.substring(p2);
        }
        return ans;
    }

    static String lcsprint(String x, String y, int m, int n){
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
        return str.reverse().toString();
    }
}
