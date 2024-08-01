package dsa.searchAlgo;

import java.util.Arrays;

public class TwoDArraySearchRowColumnSorted {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 23, 33, 41},
                {14, 25, 35, 44},
                {17, 28, 38, 45},
                {19, 29, 39, 47}
        };

        System.out.println(Arrays.toString(search(arr, 10)));
    };

    static int[] search(int[][] arr, int target){
        int r = 0;
        int c = arr.length - 1;

        while (r < arr.length && c >= 0){
            if(arr[r][c] == target){
                return new int[]{r,c};
            }
            if(arr[r][c] < target){
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};
    }

}
