package dsa.DP.knapsackChildren;

public class CountSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum = 10;

        System.out.println(countSubsetSum(arr, sum));
    }
    public static int countSubsetSum(int[] arr, int sum){
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
