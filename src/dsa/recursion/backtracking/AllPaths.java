package dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] p = new int[maze.length][maze[0].length];
        allPathsPrint("", maze, p, 0, 0, 1);
//        allPaths("", maze, 0,0);
    }

    static void allPaths(String path, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;

        if(r < maze.length - 1){
            allPaths(path + "D", maze, r+1, c);
        }
        if(c < maze[0].length - 1){
            allPaths(path + "R", maze, r, c+1);
        }
        if(r > 0){
            allPaths(path + "U", maze, r-1, c);
        }
        if(c > 0){
            allPaths(path+ "L", maze, r, c-1);
        }

        maze[r][c] = true;
    }

    static void allPathsPrint(String path, boolean[][] maze,int[][] p, int r, int c, int step){

        if(r == maze.length - 1 && c == maze[0].length - 1){
            p[r][c] = step;
            for(int[] arr: p){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(path);
            System.out.println();
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        p[r][c] = step;

        if(r < maze.length - 1){
            allPathsPrint(path + "D", maze, p, r+1, c, step+1);
        }
        if(c < maze[0].length - 1){
            allPathsPrint(path + "R", maze, p, r, c+1, step+1);
        }
        if(r > 0){
            allPathsPrint(path + "U", maze,  p,r-1, c, step+1);
        }
        if(c > 0){
            allPathsPrint(path+ "L", maze, p, r, c-1, step+1);
        }

        maze[r][c] = true;
        p[r][c] = 0;
    }
}
