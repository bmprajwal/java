package dsa.searchAlgo;

import java.util.Arrays;

public class BinarySearchSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6 , 7 , 8},
                {9, 10, 11, 12},
                {13, 14, 15 , 16}
        };
        System.out.println(Arrays.toString(search(arr, 10)));
    }

    static int[] search(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;
        // till we have 2 cols left
        while (rStart < (rEnd - 1)){
            int mid = rStart + (rEnd - rStart) / 2;
            if(arr[mid][cMid] == target){
                return new int[]{mid, cMid};
            }
            if(arr[mid][cMid] < target){
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // search in middle column
        if(arr[rStart][cMid] == target){
            return new int[]{rStart, cMid};
        }
        if(arr[rStart + 1][cMid] == target){
            return new int[]{rStart + 1, cMid};
        }

        // search in 4 spaces
        // 1st space
        if(target <= arr[rStart][cMid - 1]){
            return binarySearch(arr, rStart, 0, cMid - 1, target);
        }
        // 2nd space
        if(target <= arr[rStart + 1][cMid - 1]){
            return binarySearch(arr, rStart + 1, 0, cMid - 1, target);
        }
        // 3rd space
        if(target >= arr[rStart][cMid + 1] && target <= arr[rStart][cols - 1]){
            return binarySearch(arr, rStart, cMid + 1, cols - 1,target);
        }
        // 4th space
        else {
            return binarySearch(arr, rStart + 1, cMid + 1, cols - 1,target);
        }

    }

    static int[] binarySearch(int[][] arr, int row, int cStart, int cEnd, int target){

        while (cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;
            if(arr[row][mid] == target){
                return new int[]{row, mid};
            }
            if(arr[row][mid] < target){
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
