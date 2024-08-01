package dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {0,1,1}, {1,0,1}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOrangesCount = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    rotten.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    freshOrangesCount++;
                }
            }
        }

        if(freshOrangesCount == 0){
            return 0;
        }
        if(rotten.isEmpty()){
            return -1;
        }
        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1,0}};
        int minutes = -1;
        while (!rotten.isEmpty()){
            int size = rotten.size();
            while (size > 0){
                int[] rotOrange = rotten.remove();
                for(int[] d: dir){
                    int x = d[0] + rotOrange[0];
                    int y = d[1] + rotOrange[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshOrangesCount--;
                        rotten.add(new int[]{x, y});
                    }
                }
                size--;
            }
            minutes++;
        }
        if(freshOrangesCount > 0){
            return -1;
        }
        return minutes;
    }
}
