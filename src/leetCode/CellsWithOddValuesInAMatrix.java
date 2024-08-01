package leetCode;

public class CellsWithOddValuesInAMatrix {
    public static void main(String[] args) {
        int[][] indices = {
                {0,1},
                {1,1}
        };
        int m = 2;
        int n = 3;
        System.out.println(oddCells(m, n, indices));
    }

    static int oddCells(int m, int n, int[][] indices){
        int[][] matrix = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int[] index : indices) {
                matrix[index[0]][i]++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int[] index : indices) {
                matrix[i][index[1]]++;
            }
        }
        int noOfOddCells = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] % 2 != 0) {
                    noOfOddCells++;
                }
            }
        }
        return noOfOddCells;
    }
}
