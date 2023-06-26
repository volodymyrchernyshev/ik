package org.ik.graph.foundation;

import java.util.ArrayList;
import java.util.Collections;

public class ConvertEdgeListToAdjacencyList {


    static ArrayList<ArrayList<Integer>> convert_edge_list_to_adjacency_list(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for(int i =0; i < n; i++){
            ret.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            Integer v1 = edge.get(0);
            Integer v2 = edge.get(1);
            ret.get(v1).add(v2);
            ret.get(v2).add(v1);
        }
        for (ArrayList<Integer> l : ret) {
            Collections.sort(l);
        }
        return ret;
    }



}
