package dsa.arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {2,8,3,9,6,5,4};
        System.out.println(getSum(arr, 0,5));
    }
    static int getSum(int[] arr, int s, int e){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i-1];
        }
        return (s-1 > 0)? prefix[e] - prefix[s-1]: prefix[e];
    }
}
