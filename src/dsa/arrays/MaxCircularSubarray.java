package dsa.arrays;

import java.util.Arrays;

public class MaxCircularSubarray {
    public static void main(String[] args) {
        int[] arr = {8,-4, 3,-5,4};
        System.out.println(maxCircularSubarraySum(arr));
    }
    static int maxSubarraySum(int[] arr){
        // Kadane's algorith: local_max of index i = maximum of A[i] and A[i] + local_max of index-1;
        int local_max = arr[0];
        int global_max = arr[0];
        for(int i = 1; i < arr.length; i++){
            local_max = Math.max(arr[i], arr[i] + local_max);
            global_max = Math.max(global_max, local_max);
        }
        return global_max;
    }
    static int maxCircularSubarraySum(int[] arr){
        int max_normal = maxSubarraySum(arr);
        if(max_normal < 0){
            return max_normal;
        }
        int arr_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr_sum += arr[i];
            arr[i] = -arr[i];
        }

        int circular_sum = arr_sum + maxSubarraySum(arr);
        return Math.max(max_normal, circular_sum);
    }
}
