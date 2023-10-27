package org.leetcode.q75.hashmapset;

import java.util.*;

public class EqualRowAndColumnPairs {

    /**
     * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
     * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
     */


    public int equalPairs(int[][] grid) {

        Map<Integer, List<Integer>> rowsHashIndex = new HashMap<>();

        for(int i = 0; i < grid.length; i++){
            int[] row = grid[i];
            int hash = 0;
            for (int r : row) {
                hash += r;
            }
            rowsHashIndex.computeIfAbsent(hash, (k) ->new ArrayList<>()).add(i);
        }

        int ret = 0;

        for(int j =0 ; j < grid[0].length; j++) {
            int hash = 0;
            for (int i = 0; i < grid.length; i++) {
                int[] row = grid[i];
                hash += row[j];
            }
            if(rowsHashIndex.containsKey(hash)){
                List<Integer> rows = rowsHashIndex.get(hash);
                for (Integer row : rows) {
                    if(equals(j, row, grid)){
                        ret ++;
                    }
                }
            }
        }

        return ret;
    }

    private boolean equals(Integer columnI, Integer rowI, int[][] grid) {
        int[] row = grid[rowI];

        for(int i = 0, j = 0; i < grid.length && j < row.length; i++, j++){
            int[] cr = grid[i];
            if(cr[columnI] != row[j]){
                return false;
            }
        }

        return true;
    }


}
