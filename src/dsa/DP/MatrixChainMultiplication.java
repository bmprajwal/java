package dsa.DP;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {40,30,20,40, 30};
        int[][] t = new int[arr.length+1][arr.length+1];
        for (int[] ints : t) {
            Arrays.fill(ints, -1);
        }
        System.out.println("DP answer: " + solveMemo(arr, t, 1, arr.length-1));
        System.out.println("Recursive answer: " + solveRecursive(arr, 1, arr.length-1));
    }

    public static int solveRecursive(int[] arr, int i , int j){
        if(i >= j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int temp = solveRecursive(arr, i, k) + solveRecursive(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
            min = Math.min(min, temp);
        }
        return min;
    }

    public static int solveMemo(int[] arr, int[][] t, int i, int j){
        if(i>=j){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j-1 ; k++) {
            int temp = solveMemo(arr, t, i, k) + solveMemo(arr, t, k+1, j) + arr[i-1] * arr[k] * arr[j];
            min = Math.min(min, temp);
        }
        return t[i][j] = min;
    }

}
