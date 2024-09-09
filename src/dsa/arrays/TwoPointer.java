package dsa.arrays;

public class TwoPointer {
    public static void main(String[] args) {
        int[] arr = {2,5,8,12,30};
        System.out.println(twoPointer(arr, 17));
    }
    static boolean twoPointer(int[] arr, int sum){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int curr = arr[i] + arr[j];
            if(curr == sum){
                return true;
            }
            if(curr > sum){
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
