package dsa.DP.MCMchildren;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BooleanParenthesizationMemo {
    static int[][][] t;
    public static void main(String[] args) {
        String s = "T|T&F^T"; //4
        int n = s.length();
        t = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        System.out.println(solve(s, 0, n - 1, true));
    }

    static int solve(String s, int i, int j, boolean isTrue){
        if(i > j){
            return 0;
        }

        if(i == j){
            if(isTrue){
                return s.charAt(i) == 'T'? 1 : 0;
            } else {
                return s.charAt(i) == 'F'? 1 : 0;
            }
        }

        if(isTrue){
            if(t[i][j][1] != -1){
                return t[i][j][1];
            }
        } else {
            if(t[i][j][0] != -1){
                return t[i][j][0];
            }
        }


        int ans = 0;
        for(int k = i+1; k <= j-1; k += 2){
            int lT = solve(s, i, k-1, true);
            int lF = solve(s, i, k-1, false);
            int rT = solve(s, k+1, j, true);
            int rF = solve(s, k+1, j, false);

            if(s.charAt(k) == '&'){
                if(isTrue){
                    ans += lT * rT;
                } else {
                    ans += lT * rF + lF * rT + lF * rF;
                }
            } else if(s.charAt(k) == '|'){
                if(isTrue){
                    ans += lT * rT + lT * rF + lF * rT;
                } else {
                    ans += lF * rF;
                }
            } else if(s.charAt(k) == '^'){
                if(isTrue){
                    ans += lT * rF + lF * rT;
                } else {
                    ans += lT * rT + lF * rF;
                }
            }
        }

        if (isTrue) {
            t[i][j][1] = ans % 1003;
        } else {
            t[i][j][0] = ans % 1003;
        }
        return ans % 1003;
    }
}
