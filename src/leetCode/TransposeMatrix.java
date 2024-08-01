package leetCode;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3},
                {4,5,6},
        };

        for(int[] arr: transpose(mat)){
            System.out.println(Arrays.toString(arr));
        }
    }

    static public int[][] transpose(int[][] matrix) {
        int[][] trans = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                trans[row][col] = matrix[col][row];
            }
        }
        return trans;
    }
}
