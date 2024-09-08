package dsa.arrays;

import java.util.Arrays;

public class RightRotate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rightRotate(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
    static void rightRotate(int[] arr, int d){
        d = d % arr.length;
        reverse(arr, 0, arr.length - d - 1);
        reverse(arr, arr.length - d , arr.length -1);
        reverse(arr, 0, arr.length - 1);
    }

    static void reverse(int[] arr, int low, int high){
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
