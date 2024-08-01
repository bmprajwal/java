package leetCode;
//https://leetcode.com/problems/richest-customer-wealth/description/

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] arr = {
                {1,5},
                {7,3},
                {3,5}
        };

        System.out.println(maxWealth(arr));
    }

    static int maxWealth(int[][] accounts){
        int ans = Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            int sum = 0;
            for (int acc = 0; acc < accounts[person].length; acc++) {
                sum += accounts[person][acc];
            }
            if (sum > ans){
                ans = sum;
            }
        }
        return ans;
    }
}
