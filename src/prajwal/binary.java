package prajwal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class binary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getLevelWithMaxEvenNumbers(arr, n));
    }

    public static int getLevelWithMaxEvenNumbers(int[] arr, int n){
        int maxLevel = -1;
        int maxEvenCount = 0;

        int levels = (int) (Math.log(n) / Math.log(2)) + 1;

        for (int level = 0; level < levels; level++) {
            int startIdx = (int) Math.pow(2, level) - 1;
            int endIdx = Math.min((int) Math.pow(2, level + 1) - 1, n);
            int evenCount = 0;

            for (int i = startIdx; i < endIdx; i++) {
                if (arr[i] % 2 == 0) {
                    evenCount++;
                }
            }

            if (evenCount > maxEvenCount) {
                maxEvenCount = evenCount;
                maxLevel = level;
            }
        }

        return maxLevel+ 1;
    }
}
