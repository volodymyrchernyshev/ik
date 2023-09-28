package org.ik.graph.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class KnightsTourOnAChessboard {


    @Test
    public void test() {
        Assertions.assertEquals(3, find_minimum_number_of_moves(5, 5, 0, 0, 4, 1));
        Assertions.assertEquals(2, find_minimum_number_of_moves(5, 5, 1, 1, 4, 4));
    }


    static Integer find_minimum_number_of_moves(Integer rows, Integer cols, Integer start_row, Integer start_col, Integer end_row, Integer end_col) {
        // Write your code here.
        if (start_row.equals(end_row) && start_col.equals(end_col)) {
            return 0;
        }

        return bfs(rows, cols, new int[]{start_row, start_col}, new int[]{end_row, end_col});
    }

    private static int bfs(Integer rows, Integer cols, int[] start, int[] end) {
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] next : getNext(current)) {
                    if (!isValid(next, rows, cols) || visited[next[0]][next[1]]) {
                        continue;
                    }
                    if (end[0] == next[0] && end[1] == next[1]) {
                        return count;
                    }
                    visited[next[0]][next[1]] = true;
                    queue.add(next);
                }
            }
        }


        return -1;
    }

    private static boolean isValid(int[] next, int rows, int cols) {
        return next[0] >= 0 && next[0] < rows && next[1] >= 0 && next[1] < cols;
    }

    private static int[][] getNext(int[] current) {

        return new int[][]{new int[]{current[0] + 2, current[1] - 1}, new int[]{current[0] + 2, current[1] + 1}, new int[]{current[0] - 2, current[1] - 1}, new int[]{current[0] - 2, current[1] + 1},
                new int[]{current[0] + 1, current[1] + 2}, new int[]{current[0] + 1, current[1] - 2}, new int[]{current[0] - 1, current[1] - 2}, new int[]{current[0] - 1, current[1] + 2}
        };
    }


}
