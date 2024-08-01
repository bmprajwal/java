package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PositiveCumulativeSum {
    public static void main(String[] args) {
        int[] arr = {1, -1, -1, -1, 1};
        System.out.println(posCumSum(arr));
    }
    static List<Integer> posCumSum(int[] arr){
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for (int j : arr) {
            sum += j;
            if (sum > 0) {
                list.add(sum);
            }
        }
        return list;
    }
}
