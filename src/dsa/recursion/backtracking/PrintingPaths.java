package dsa.recursion.backtracking;

public class PrintingPaths {
    public static void main(String[] args) {
//        pathWithDiag("", 3,3);

        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {false, true, true}
        };

        pathRestrictions("", maze, 0,0);
    }

    static void path(String path, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(path);
            return;
        }

        if(r > 1){
            path(path + "D", r-1, c);
        }
        if(c > 1){
            path(path + "R", r, c -1);
        }

    }
    static void pathWithDiag(String path, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(path);
            return;
        }

        if(r > 1 && c > 1){
            pathWithDiag(path + "V", r-1, c-1);
        }
        if(r > 1){
            pathWithDiag(path + "D", r-1, c);
        }
        if(c > 1){
            pathWithDiag(path + "R", r, c -1);
        }

    }

    static void pathRestrictions(String path,boolean[][] maze, int r, int c){
        if(r == maze.length -1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length - 1){
            pathRestrictions(path + "D", maze, r+1, c);
        }
        if(c < maze[0].length - 1){
            pathRestrictions(path + "R",maze, r, c +1);
        }

    }
}
