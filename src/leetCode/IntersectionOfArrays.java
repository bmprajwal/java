package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int n: nums1){
            s1.add(n);
        }
        for(int n: nums2){
            if(s1.contains(n)){
                s2.add(n);
            }
        }
        int[] res = new int[s2.size()];
        int i = 0;
        for(int n: s2){
            res[i++] = n;
        }
        return res;
    }
}
