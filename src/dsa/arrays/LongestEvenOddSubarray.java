package dsa.arrays;

public class LongestEvenOddSubarray {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3,6,9,2};
        System.out.println(kadane(arr));
    }
    static int kadane(int[] arr){
        int count = 1;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if((arr[i]%2 == 0 && arr[i-1]%2 != 0) || (arr[i]%2 != 0 && arr[i-1]%2 == 0)){
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }
        return res;
    }
}
