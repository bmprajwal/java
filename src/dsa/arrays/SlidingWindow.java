package dsa.arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {5,-10,6,90,3};
        System.out.println(maxSumK(arr, 2));
    }
    static int maxSumK(int[] arr, int k){
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int res = sum;
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i-k]; // add the last element of the current window and delete the first element of prev window
            res = Math.max(res, sum);
        }
        return res;
    }
}
