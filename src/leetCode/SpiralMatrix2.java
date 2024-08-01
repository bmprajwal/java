package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int[][] result = spiralOrder2(1);
        for(int[] arr: result){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] spiralOrder2(int n) {
        int[][] result = new int[n][n];
        int currentNo = 1;
        int rows = n, cols = n;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = currentNo;
                currentNo++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = currentNo;
                currentNo++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = currentNo;
                    currentNo++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = currentNo;
                    currentNo++;
                }
                left++;
            }
        }

        return result;
    }
}
