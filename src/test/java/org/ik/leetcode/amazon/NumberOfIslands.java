package org.ik.leetcode.amazon;

import org.junit.jupiter.api.Test;

public class NumberOfIslands {


    @Test
    public void test() {

        System.out.println(numIslands(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', 1, '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        }));
    }

    public int numIslands(char[][] grid) {
        int ret = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ret++;
                    travel(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void travel(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        travel(grid, i - 1, j);
        travel(grid, i + 1, j);
        travel(grid, i, j - 1);
        travel(grid, i, j + 1);
    }

}
