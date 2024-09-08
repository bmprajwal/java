package dsa.arrays;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,4,20,3,10,5};
        int sum = 33;
        System.out.println(subarraySumNaive(arr, sum));
    }
    static boolean subarraySumNaive(int[] arr, int sum ) {
        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                curr += arr[j];
                if(curr == sum){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean subarraySum(int[] arr, int sum){
        int s = 0;
        int curr = 0;
        for (int e = 0; e < arr.length; e++) {
            curr += arr[e];
            while (sum < curr){
                curr -= arr[s];
                s++;
            }
            if(curr == sum){
                return true;
            }
        }
        return false;
    }
}
