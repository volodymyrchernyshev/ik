package org.ik.graph.foundation;

import java.util.ArrayList;

public class ConvertEdgeListToAdjacencyMatrix {



    static ArrayList<ArrayList<Boolean>> convert_edge_list_to_adjacency_matrix(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Boolean>> ret = new ArrayList<>();

        for(int i =0; i < n; i++){
            ArrayList<Boolean> row = new ArrayList<>(n + 1);
            for(int j = 0; j < n; j++){
                row.add(false);
            }
            ret.add(row);
        }

        for (ArrayList<Integer> edge : edges) {
            Integer v1 = edge.get(0);
            Integer v2 = edge.get(1);
            // set row
            ret.get(v1).set(v2, true);
            //set column
            ret.get(v2).set(v1, true);
        }

        return ret;
    }


}
