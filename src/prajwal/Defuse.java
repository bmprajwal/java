package prajwal;

import java.util.Arrays;
import java.util.Scanner;

public class Defuse {
    public static void main(String[] args) {
        int key = -7;
        int[] arr = {2,3,6,4,5};
        int[] result = defuseBomb(arr, key);
        System.out.println(Arrays.toString(result));
    }

    static int[] defuseBomb(int[] arr, int key){
        int n = arr.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 1; j <= Math.abs(key) ; j++) {
                int k = 0;
                if(key < 0){
                    k = (i - j) % n;
                    if(k < 0){
                        k = n + k;
                    }
                } else {
                    k = (i + j) % n;
                }
                sum += arr[k];
            }
            result[i] = sum;
        }
        return result;
    }
}
