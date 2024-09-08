package dsa.arrays;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3};
        System.out.println(removeDup(arr));
        System.out.println(Arrays.toString(arr));
    }
    static int removeDup(int[] arr){
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[res-1]){
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }
}
