package org.ik.graph;

import java.util.*;

public class BFSTraversalOfAGraph {


    static ArrayList<Integer> bfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> adjacencyList = createAdjancencyList(n, edges);

        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, Boolean.FALSE);
        ArrayList<Integer> ret = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Boolean visit = visited[i];
            if(!visit){
                BFS(adjacencyList, visited, ret, i);
            }
        }

        return ret;
    }

    private static void BFS(ArrayList<ArrayList<Integer>> adjacencyList, Boolean[] visited, ArrayList<Integer> ret, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            ret.add(current);
            for (Integer next : adjacencyList.get(current)) {
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
