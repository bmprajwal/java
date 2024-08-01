package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };
        System.out.println(luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers (int[][] matrix){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] rowMin = findRowMin(matrix, i);
            boolean isMax = isMax(matrix, rowMin[0], rowMin[1]);
            if(isMax){
                res.add(rowMin[0]);
            }
        }
        return res;
    }

    private static boolean isMax(int[][] matrix,  int ele, int index) {

        for (int[] ints : matrix) {
            if (ints[index] > ele) {
                return false;
            }
        }
        return true;
    }

    public static int[] findRowMin(int[][] matrix, int i) {
        int min = matrix[i][0];
        int index = 0;
        for (int j = 1; j < matrix[i].length; j++) {
            if(matrix[i][j] < min){
                min = matrix[i][j];
                index = j;
            }
        }
        return new int[]{min, index};
    }
}
