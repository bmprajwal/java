package dsa.DP.knapsackChildren;

public class MinimumSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(minSubsetSumDiff(arr));
    }

    static int minSubsetSumDiff(int[] arr){
        int range = 0;
        int n = arr.length;
        for (int k : arr) {
            range += k;
        }
        boolean[][] t = new boolean[n+1][range+1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= range / 2; i++) {
            if(t[n][i]){
                min = Math.min(min, range - 2*i);
            }
        }
        return min;
    }
}
