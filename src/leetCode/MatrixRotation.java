package leetCode;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] mat = {
                {0,1},
                {1,1}
        };
        int[][] target = {
                {1,0},
                {0,1}
        };
        System.out.println(findRotation(mat, target));

    }
    public static boolean findRotation(int[][] mat, int[][] target) {
        int noOfRotations = 4;
        for (int i = noOfRotations; i > 0 ; i--) {
            rotate90Clockwise(mat);
            if(isMatrixEqual(mat,target)){
                return true;
            }
        }
        return false;
    }
    public static void rotate90Clockwise(int[][] a)
    {
        int N = a.length;

        for (int i = 0; i < N / 2; i++)
        {
            for (int j = i; j < N - i - 1; j++)
            {
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    public static boolean isMatrixEqual(int[][] arr1, int[][] arr2){
        boolean isEqual = true;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if(arr1[i][j] != arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
