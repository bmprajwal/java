package leetCode;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,9,2,2};
        int target = 9;
        System.out.println(search(arr, target));
    }
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot -1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
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

    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if( mid - 1 >= start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if(arr[start] == arr[mid] && arr[end] == arr[end]){
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                if(arr[end - 1] > arr[end]){
                    return end - 1;
                }
                end--;
            } else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] nums, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
