package dsa.arrays;

public class FirstOne {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,};
        System.out.println(firstOne(arr));
    }
    static int firstOne(int[] arr){
        return firstOne(arr, 0, arr.length-1);
    }
    static int firstOne(int[] arr, int low, int high){
        if(low > high){
            return -1;
        }
        int key = 1;
        int mid = low + (high - low )/ 2;
        if(mid == 0 || key > arr[mid-1] && arr[mid] == key){
            return mid;
        } else if(key > arr[mid]){
            return firstOne(arr, mid+1, high);
        } else {
            return firstOne(arr, low, mid-1);
        }
    }
}
