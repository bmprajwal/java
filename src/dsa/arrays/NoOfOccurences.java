package dsa.arrays;

public class NoOfOccurences {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,2,3,3,4,4,4};
        System.out.println(count(arr, 2));
    }
    static int count(int[] arr, int key){
        int f = firstIndex(arr, 0, arr.length - 1, key);
        int l = lastIndex(arr, 0, arr.length-1, key);
        return l - f + 1;
    }
    static int firstIndex(int[] arr, int low, int high, int key){
        if(high >= low){
            int mid = low + (high - low) / 2;
            if(mid == 0 || key > arr[mid-1] && arr[mid] == key){
                return mid;
            } else if(key > arr[mid]){
                return firstIndex(arr, mid+1, high, key);
            } else {
                return firstIndex(arr, low, mid-1, key);
            }
        }
        return -1;
    }
    static int lastIndex(int[] arr, int low, int high, int key){
        if(high >= low){
            int mid = low + (high - low) / 2;
            if(mid == arr.length - 1 || key < arr[mid+1] && arr[mid] == key){
                return mid;
            } else if(key < arr[mid]){
                return lastIndex(arr, low, mid-1, key);
            } else {
                return lastIndex(arr, mid+1, high, key);
            }
        }
        return -1;
    }
}
