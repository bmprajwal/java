package leetCode;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
        };
        System.out.println(diagonalSum(mat));
    }
    static public int diagonalSum(int[][] mat) {
        int primD = 0;
        int secD = mat[0].length - 1;
        int sum = 0;
        for (int[] ints : mat) {
            if (primD != secD) {
                sum = sum + ints[primD] + ints[secD];
            } else {
                sum += ints[primD];
            }
            primD++;
            secD--;
        }
        return sum;
    }
}
