package dsa.DP.knapsackChildren;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {3,5,11,7};
        System.out.println(equalSumPartition(arr));
    }
    static boolean equalSumPartition(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        if(sum % 2 != 0){
            return false;
        } else {
            return subsetSum(arr, sum/2);
        }
    }

    static boolean subsetSum(int[] arr, int sum){
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if(i == 0){
                    t[i][j] = false;
                }
                if(j == 0){
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
