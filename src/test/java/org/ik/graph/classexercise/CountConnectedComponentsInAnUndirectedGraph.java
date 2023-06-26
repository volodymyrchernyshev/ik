package org.ik.graph.classexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountConnectedComponentsInAnUndirectedGraph {


    static Integer number_of_connected_components(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> list = createAdjancencyList(n, edges);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int count = 0;

        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                BFS(list, i, visited);
                count++;
            }
        }

        return count;
    }

    private static void BFS(ArrayList<ArrayList<Integer>> list, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            for (Integer next : list.get(current)) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }


    private static ArrayList<ArrayList<Integer>> createAdjancencyList(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            adjacencyList.get(edge.get(0)).add(edge.get(1));
            adjacencyList.get(edge.get(1)).add(edge.get(0));
        }
        return adjacencyList;
    }


}
