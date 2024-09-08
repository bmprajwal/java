package dsa.arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] arr = {1,3};
        System.out.println(sorted(arr));
    }
    static boolean sorted(int[] arr, int index){
        if(index == arr.length -1){
            return true;
        }
        return arr[index] < arr[index+ 1] && sorted(arr, index + 1);
    }
    static boolean sorted(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
