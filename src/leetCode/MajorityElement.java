package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        for(int key: map.keySet()){
            if(map.get(key) > n/2){
                return key;
            }
        }
        return 0;
    }
}
