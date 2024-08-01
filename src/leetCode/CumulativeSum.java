package leetCode;

import java.util.Arrays;

public class CumulativeSum {
    public static void main(String[] args) {
        int[] arr = {1, -1, -1, -1, 1};
        System.out.println(Arrays.toString(cumSum(arr)));
    }
    static int[] cumSum(int[] arr){
        int sum = 0;
        int[] cumSumArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            cumSumArr[i] = sum;
        }
        return cumSumArr;
    }
}
