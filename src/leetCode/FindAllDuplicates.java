package leetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
    static List<Integer> findDuplicates(int[]nums){
        int i = 0;
        while (i < nums.length){

                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]){
                    swap(nums, i, correct);
                } else {
                    i++;
                }
        }
        List<Integer> duplicates = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index + 1){
                duplicates.add(nums[index]);
            }
        }
        return duplicates;
    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
