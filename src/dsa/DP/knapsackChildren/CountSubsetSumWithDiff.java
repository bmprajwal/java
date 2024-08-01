package dsa.DP.knapsackChildren;

public class CountSubsetSumWithDiff {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;
        System.out.println(countSubsetSumWithDiff(arr, diff));
    }

    static int countSubsetSumWithDiff(int[] arr, int diff){
        int sum = 0;
        for(int ele: arr){
            sum += ele;
        }
        int target = (diff + sum) / 2;

        int n = arr.length;
        int[][] t = new int[n+1][target+1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][target];
    }
}
