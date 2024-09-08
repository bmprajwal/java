package dsa.arrays;

public class TrappingWater {
    public static void main(String[] args) {
        int[] arr = {3,0,1,2,5};
        System.out.println(maxTrap1(arr));
    }
    static int maxTrap(int[] arr){
        // TC: O(n*n)
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int lmax = arr[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }
            int rmax = arr[i];
            for (int j = i; j < arr.length; j++) {
                rmax = Math.max(rmax, arr[j]);
            }
            res += Math.min(lmax, rmax) - arr[i];
        }
        return res;
    }
    static int maxTrap1(int[] arr){
        //TC: O(n) but space complexity: O(N)
        int res = 0;
        int[] lmax = new int[arr.length];
        int[] rmax = new int[arr.length];
        lmax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lmax[i] = Math.max(arr[i], lmax[i-1]);
        }
        rmax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0 ; i--) {
            rmax[i] = Math.max(arr[i], rmax[i+1]);
        }
        for (int i = 0; i < arr.length; i++) {
            res += Math.min(lmax[i], rmax[i]) - arr[i];
        }
        return res;
    }
}
