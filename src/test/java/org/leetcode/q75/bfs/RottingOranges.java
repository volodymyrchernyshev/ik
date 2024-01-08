package org.leetcode.q75.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {


    /**
     *You are given an m x n grid where each cell can have one of three values:
     *
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
     */

    public int orangesRotting(int[][] grid) {
        // boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i - 1, j});
                    q.add(new int[]{i + 1, j});
                    q.add(new int[]{i, j - 1});
                    q.add(new int[]{i, j + 1});
                }
            }
        }

        while(!q.isEmpty()){
            int n = q.size();

            boolean rot = false;
            for(int i = 0; i < n; i++){
                int[] cell = q.poll();
                if(cell[0] < 0 || cell[1] < 0
                        || cell[0] >= grid.length || cell[1] >= grid[cell[0]].length
                        // || visited[cell[0]][cell[1]]
                        || grid[cell[0]][cell[1]] != 1){
                    continue;
                }

                grid[cell[0]][cell[1]] = 2;
                rot = true;
                q.add(new int[]{cell[0]-1, cell[1]});
                q.add(new int[]{cell[0]+1, cell[1]});
                q.add(new int[]{cell[0], cell[1]-1});
                q.add(new int[]{cell[0], cell[1]+1});

            }
            if(rot){
                count ++;
            }

        }

        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;

    }
}
