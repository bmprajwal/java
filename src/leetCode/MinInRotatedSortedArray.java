package leetCode;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
    static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        if(pivot == -1){
            return nums[0];
        }
        return nums[pivot + 1];
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            } else if( mid - 1 >= start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            } else if(arr[start] >= arr[mid]){
                end = mid - 1;
            } else if(arr[start] < arr[mid]){
                start = mid + 1;
            }
        }
        return -1;
    }
}
