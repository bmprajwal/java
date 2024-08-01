package dsa.DP.MCMchildren;

import java.util.Arrays;

public class EggDropping {
    static int[][] t;
    public static void main(String[] args) {
        int e = 2;
        int f = 100;
        t = new int[e+1][f+1];
        for(int[] arr: t){
            Arrays.fill(arr, -1);
        }
        System.out.println(eggDrop(e,f));
    }

    static int eggDrop(int e, int f){
        if(f <= 1){
            return f;
        }
        if(e == 1){
            return f;
        }
        if(t[e][f] != -1){
            return t[e][f];
        }
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f ; k++) {
            int temp = 1 + Math.max(eggDrop(e-1, k-1), eggDrop(e, f-k));
            min = Math.min(min, temp);
        }
        return t[e][f] = min;
    }
}
