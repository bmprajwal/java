package dsa.sortAlgo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10,3,14,6, 19,9};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int l,int r){
        if(r > l){
            int m = l + (r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    static void merge(int[] arr, int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int k = 0;
        int[] res = new int[high-low + 1];
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                res[k] = arr[i];
                i++;
            } else {
                res[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            res[k] = arr[i];
            i++;
            k++;
        }
        while(j <= high){
            res[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < res.length; l++) {
            arr[low+l] = res[l];
        }
    }
}
