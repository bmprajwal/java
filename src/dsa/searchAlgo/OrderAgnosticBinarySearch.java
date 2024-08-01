package dsa.searchAlgo;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] desArr = {98, 64,43,21,12,5,2,1,-8,-29};
        int[] ascArr = {-19, -12, -8, 0, 2,3,8,9,14, 45, 67, 93};
        int target = 45;
        System.out.println(orderAgnosticBS(ascArr, target));
    }

    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target < arr[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
