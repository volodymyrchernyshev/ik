package org.ik.graph.foundation;

import java.util.ArrayList;
import java.util.Arrays;

public class DFSTraversalOfAGraph {



    static ArrayList<Integer> dfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<Integer> ret = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = convertToAdjancencyList(edges, n);

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for(int i = 0; i  < n; i++){
            if(!visited[i]){
                recursiveDFS(list, i, visited, ret);
            }
        }

        return ret;
    }

    private static void recursiveDFS(ArrayList<ArrayList<Integer>> list, int current, boolean[] visited, ArrayList<Integer> ret) {
        visited[current] = true;
        ret.add(current);
        for (Integer child : list.get(current)) {
            if(!visited[child]){
                recursiveDFS(list, child, visited, ret);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> convertToAdjancencyList(ArrayList<ArrayList<Integer>> edges, int n) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ret.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            ret.get(edge.get(0)).add(edge.get(1));
            ret.get(edge.get(1)).add(edge.get(0));
        }

        return ret;
    }


}
