package leetCode;

import java.util.ArrayList;
import java.util.List;

public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {42, 564, 5775, 34, 123, 454, 1, 5, 45, 3556, 23442};
        System.out.println(findNumbers(nums));
    }

    static List<Integer> findNumbers(int[]arr){
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (evenLength(j)) {
                list.add(j);
            }
        }
        return list;
    }

    static boolean evenLength(int ele){
        return noOfDigits(ele) % 2 == 0;
    }

    static int noOfDigits(int ele){
        return (int) Math.log10(ele) + 1;
    }
}
