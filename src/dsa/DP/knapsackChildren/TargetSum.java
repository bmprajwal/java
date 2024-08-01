package dsa.DP.knapsackChildren;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,1000};
        int sum = -1000;
        System.out.println(targetSum(arr, sum));
    }
    static int targetSum(int[] nums, int sum){
        int n = nums.length;
        if(n == 1){
            if(nums[0] == sum || nums[0] == -sum){
                return 1;
            } else {
                return 0;
            }
        }
        int numsSum = 0;
        for(int num: nums){
            numsSum += num;
        }
        int target = sum + numsSum;
        if(target % 2 != 0){
            return 0;
        }
        if(target < 0){
            return 0;
        }
        target = target / 2;
        int[][] t = new int[n+1][target+1];
        t[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if(nums[i-1]<=j){
                    t[i][j] = t[i-1][j-nums[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][target];
    }

}
