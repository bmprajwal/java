package leetCode;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2,2,2,2};
        int target = 2;
        System.out.println(Arrays.toString(search(nums, target)));
    }

    static int[] search(int[] nums, int target){
        int[] ans = {-1, -1};
        ans[0] = binarySearch(nums, target, true);
        ans[1] = binarySearch(nums, target, false);

        return ans;
    }

    static int binarySearch(int[] nums, int target, boolean findFirstOccurence){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < nums[mid]){
                end = mid - 1;
            } else if( target > nums[mid]){
                start = mid + 1;
            } else {
                ans = mid;
                if(findFirstOccurence){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
