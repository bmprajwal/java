package dsa.arrays;

public class EquillibriumPoint {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        System.out.println(equiPoint(arr));
    }
    static boolean equiPoint(int[] arr){
        int rsum = 0;
        for(int ele: arr){
            rsum += ele;
        }
        int lsum = 0;
        for (int i = 0; i < arr.length; i++) {
            rsum -= arr[i];
            if(lsum == rsum){
                return true;
            }
            lsum += arr[i];
        }
        return false;
    }
}
