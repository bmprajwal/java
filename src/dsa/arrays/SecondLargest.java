package dsa.arrays;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10,10,10};
        System.out.println(Arrays.toString(secondLargest1(arr)));
    }
    static int secondLargest(int[] arr){
        int largest = getLargest(arr);
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != arr[largest]){
                if(res == -1 || arr[i] > arr[res]){
                    res = i;
                }
            }
        }
        return res;
    }
    static int getLargest(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[res]){
                res = i;
            }
        }
        return res;
    }

    static int[] secondLargest1(int[] arr){
        int largest = 0;
        int sec = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[largest]){
                sec = largest;
                largest = i;
            } else if(arr[i] != arr[largest]){
                if(sec == -1){
                    sec = i;
                } else {
                    if(arr[i] > arr[sec]){
                        sec = i;
                    }
                }
            }
        }
        return new int[]{largest, sec};
    }
}
