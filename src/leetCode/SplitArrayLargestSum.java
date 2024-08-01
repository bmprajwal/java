package leetCode;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(splitArray(nums, 2));
    }
    static int splitArray(int[] nums, int m){
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start < end){
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;
            for(int num: nums){
                if(sum + num > mid){
                    pieces++;
                    sum = num;
                } else {
                    sum += num;
                }
            }
            if(pieces <= m){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
