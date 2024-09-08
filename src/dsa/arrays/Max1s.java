package dsa.arrays;

public class Max1s {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0};
        System.out.println(max1s(arr));
    }
    static int max1s(int[] arr){
        int count = 0;
        int max = 0;
        for (int j : arr) {
            if (j == 1) {
                count++;
            } else if (j == 0) {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return max == 0? count: max;
    }
}
