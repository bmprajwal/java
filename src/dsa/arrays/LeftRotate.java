package dsa.arrays;

import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        leftRotate3(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
    static void leftRotateOne(int[] arr){
        if(arr.length == 0) return;
        int first = arr[0];
        int i;
        for (i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[i-1] = first;
    }

    static void leftRotate1(int[] arr, int d){
        // TC: O(n * d)
        for (int i = 0; i < d; i++) {
            leftRotateOne(arr);
        }
    }
    static void leftRotate2(int[] arr, int d){
        int[] temp = new int[d];
        for(int i = 0; i < d; i++){
            temp[i] = arr[i];
        }
        for (int i = d; i < arr.length; i++) {
            arr[i-d] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = temp[i];
        }
    }
    static void leftRotate3(int[] arr, int d){
        rotate(arr, 0, d-1);
        rotate(arr, d, arr.length -1);
        rotate(arr, 0, arr.length -1);
    }

    static void rotate(int[] arr, int low, int high){
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
