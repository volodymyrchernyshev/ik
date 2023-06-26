package org.ik.graph.classexercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class CountIslands {


    static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here.

        int count = 0;
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == 1) {
                    count++;
                    travelIsland(matrix, new int[]{i, j});
                }
            }
        }

        return count;
    }

    private static void travelIsland(ArrayList<ArrayList<Integer>> matrix, int[] coord) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(coord);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            Collection<int[]> neighbors = getNeighbors(matrix, current);
            matrix.get(current[0]).set(current[1], 0);//clear cell
            for (int[] neighbor : neighbors) {

                if (matrix.get(neighbor[0]).get(neighbor[1]).equals(1)) {
                    queue.add(neighbor);
                }
            }
        }


    }

    private static Collection<int[]> getNeighbors(ArrayList<ArrayList<Integer>> matrix, int[] current) {
        ArrayList<int[]> ret = new ArrayList<>();

        int i = current[0];
        int j = current[1];
        ArrayList<Integer> row = matrix.get(i);
        if (i > 0) {
            ret.add(new int[]{i - 1, j});

            if (j > 0) {
                ret.add(new int[]{i - 1, j - 1});
            }

            if (j < row.size() - 1) {
                ret.add(new int[]{i - 1, j + 1});
            }

        }
        if (i < matrix.size() - 1) {
            ret.add(new int[]{i + 1, j});
            if (j > 0) {
                ret.add(new int[]{i + 1, j - 1});
            }

            if (j < row.size() - 1) {
                ret.add(new int[]{i + 1, j + 1});
            }

        }


        if (j > 0) {
            ret.add(new int[]{i, j - 1});
        }

        if (j < row.size() - 1) {
            ret.add(new int[]{i, j + 1});
        }
        return ret;
    }


}
