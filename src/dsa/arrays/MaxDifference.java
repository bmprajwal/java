package dsa.arrays;

public class MaxDifference {
    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,8,1};
        System.out.println(maxDiff(arr));
    }
    static int maxDiff(int[] arr){
        int res = arr[1] - arr[0];
        int currMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i] - currMin);
            currMin = Math.min(currMin, arr[i]);
        }
        return res;
    }
}
