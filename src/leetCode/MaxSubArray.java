package leetCode;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,-1,-3,-4,-1,-2,-1,-1,-4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
