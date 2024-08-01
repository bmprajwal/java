package leetCode;

import java.util.Arrays;

public class ReshapeMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3} , {4,5,6}};
        for(int[] arr: matrixReshape(mat, 1, 6)){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r * c != mat.length * mat[0].length){
            return mat;
        }
        int[][] reshaped = new int[r][c];
        int row = 0, col = 0;
        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                reshaped[row][col] = ints[j];
                col++;
                if (col == c) {
                    row++;
                    col = 0;
                }
            }
        }
        return reshaped;
    }
}
