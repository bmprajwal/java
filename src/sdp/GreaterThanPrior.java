package sdp;

public class GreaterThanPrior {
    public static void main(String[] args) {
        int[] arr = {7,4,8,2,9};
        int max = arr[0];
        int count = 1;
        for (int j : arr) {
            if (j > max) {
                count++;
                max = j;
            }
        }
        System.out.println(count);
    }
}
