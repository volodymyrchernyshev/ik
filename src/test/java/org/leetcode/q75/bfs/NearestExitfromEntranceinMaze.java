package org.leetcode.q75.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitfromEntranceinMaze {

    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int count = 0;

        while (!queue.isEmpty()) {

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] cell = queue.poll();

                if (cell[0] < 0 || cell[1] < 0 || cell[0] >= maze.length || cell[1] >= maze[0].length) {
                    continue;
                }

                if (maze[cell[0]][cell[1]] == '+' || visited[cell[0]][cell[1]]) {
                    continue;
                }

                if ((cell[0] == 0 || cell[1] == 0 || cell[0] == maze.length - 1 || cell[1] == maze[0].length - 1)
                        && !(cell[0] == entrance[0] && cell[1] == entrance[1])) {
                    return count;
                }
                visited[cell[0]][cell[1]] = true;

                //go left
                queue.add(new int[]{cell[0] - 1, cell[1]});
                //go righ
                queue.add(new int[]{cell[0] + 1, cell[1]});
                // go up
                queue.add(new int[]{cell[0], cell[1] - 1});
                //go down
                queue.add(new int[]{cell[0], cell[1] + 1});
            }

            count++;
        }


        return -1;
    }

}
