package dsa.arrays;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        int f = 0;
        int s = arr.length - 1;
        while (f < s){
            int temp = arr[f];
            arr[f] = arr[s];
            arr[s] = temp;
            f++;
            s--;
        }
    }
}
