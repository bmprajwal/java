package dsa.sortAlgo;

import java.util.Arrays;

public class  CyclicSort {
    public static void main(String[] args) {
        int[] arr = {4,5,2,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclic(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i + 1){
                swap(arr, i, arr[i] - 1);
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void sort(int[]arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }
}
