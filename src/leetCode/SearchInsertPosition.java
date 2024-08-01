package leetCode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchPosition(nums, 7));
    }
    public static int searchPosition(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > target){
                end = mid - 1;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
