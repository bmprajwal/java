package leetCode;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,5,3,1};
        int peakIndex = searchPeakIndex(arr);
        int target = 1;
        int ans = binarySearch(arr,target,0, peakIndex);
        if(ans == -1){
            ans = binarySearch(arr, target,peakIndex + 1, arr.length - 1);
        }
        System.out.println(ans);
    }
    static int searchPeakIndex(int[] mountainArr){
        int start = 0;
        int end = mountainArr.length - 1;

        while (start != end){
            int mid = start + (end - start) / 2;

            if(mountainArr[mid] > mountainArr[mid + 1]){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    static int binarySearch(int[] mountainArr, int target,int start, int end){


        boolean isAsc = mountainArr[start] < mountainArr[end];

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(mountainArr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < mountainArr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target < mountainArr[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
