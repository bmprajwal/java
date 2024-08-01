package leetCode;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {-19, -12, -8, 0, 2,3,8,9,14, 45, 67, 93};
        int target = -44;
        int ans = floor(arr, target);
        System.out.println(ans);
    }

    static int floor(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            } else if(target > arr[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
