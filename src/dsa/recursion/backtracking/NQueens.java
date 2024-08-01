package dsa.recursion.backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];

        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int r){
        if(r == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        // placing the queen if it is safe
        for(int c = 0; c < board[0].length; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                count += queens(board, r+1);
                board[r][c] = false;
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col){

        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        //diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft ; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        int maxRight = Math.min(row, board[0].length - col - 1);
        for (int i = 1; i <= maxRight ; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    static void display(boolean[][] board){
        for(boolean[] row: board){
            for(boolean ele: row){
                if(ele){
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
