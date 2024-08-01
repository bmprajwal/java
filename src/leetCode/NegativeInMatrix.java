package leetCode;

public class NegativeInMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        System.out.println(countNegatives(grid));
    }
    public static int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int col = cols - 1;
        int row = 0;
        while(row < rows && col >= 0){
            if(grid[row][col] >= 0){
                row++;
            } else {
                count+= rows - row;
                col--;
            }
        }
        return count;
    }
}
