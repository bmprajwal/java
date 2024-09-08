package dsa.arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-3,8,-2, 4,-5, 6};
        System.out.println(maxSubArray(arr));
    }
    // Kadane's Algorithm - local_max at index i = maximum of A[i] and sum of A[i] + local_max at index-1
    static int maxSubArray(int[] arr){
        int res = 0;
        int maxEnding = arr[0];
        for(int i = 1; i < arr.length; i++){
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}
