package leetCode;

import java.util.Arrays;

public class SumZero {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }

    public static int[] sumZero(int n){
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            res[i] = i + 1;
            sum += res[i];
        }
        res[n - 1] = -1 * sum;
        return res;
    }
}
