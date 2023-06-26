package org.ik.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CountConnectedComponentsInAnUndirectedGraph {


    static Integer number_of_connected_components(Integer n, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Integer>> list = convertToAdjancencyList(edges, n);

        int ret = 0;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for(int i = 0; i  < n; i++){
            if(!visited[i]){
                recursiveDFS(list, i, visited);
                ret++;
            }
        }



        return ret;
    }


    private static void recursiveDFS(ArrayList<ArrayList<Integer>> list, int current, boolean[] visited) {
        visited[current] = true;
        for (Integer child : list.get(current)) {
            if(!visited[child]){
                recursiveDFS(list, child, visited);
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
