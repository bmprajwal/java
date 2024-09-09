package dsa.arrays;

import java.util.ArrayList;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int sum = 12;
        System.out.println(subarraySum(arr,arr.length, sum));
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

    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {
        // code here
        int s = 0;
        int curr = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int e = 0; e < n; e++){
            curr += arr[e];
            while(sum < curr){
                curr -= arr[s];
                s++;
            }
            if(curr == sum){
                ans.add(s);
                ans.add(e);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }
}
