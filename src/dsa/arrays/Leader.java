package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Leader {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(leaders(arr));
    }

    static ArrayList<Integer> leaders(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = arr.length -1; i > 0; i--){
            if(arr[i] > max){
                ans.add(0, arr[i]);
                max = arr[i];
            }
        }
        return ans;
    }
}
