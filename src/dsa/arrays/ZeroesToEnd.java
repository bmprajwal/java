package dsa.arrays;

import java.util.Arrays;

public class ZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void moveZeroes(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
    }
}
