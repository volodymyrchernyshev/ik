package org.ik.graph.foundation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckIfEulerianCycleExists {



    static Boolean check_if_eulerian_cycle_exists(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        Map<Integer, Integer> degrees = new HashMap<>();

        for (ArrayList<Integer> edge : edges) {
            Integer start = edge.get(0);
            Integer end = edge.get(1);
            degrees.compute(start, (k,v) -> v == null ? 1 : v+1);
            degrees.compute(end, (k,v) -> v == null ? 1 : v+1);
        }

        for (Map.Entry<Integer, Integer> entry : degrees.entrySet()) {
            if(entry.getValue() %2 == 1){
                return false;
            }
        }
        return true;
    }


    static Boolean check_if_eulerian_path_exists(Integer n, ArrayList<ArrayList<Integer>> edges) {
        Map<Integer, Integer> degrees = new HashMap<>();

        for (ArrayList<Integer> edge : edges) {
            Integer start = edge.get(0);
            Integer end = edge.get(1);
            degrees.compute(start, (k,v) -> v == null ? 1 : v+1);
            degrees.compute(end, (k,v) -> v == null ? 1 : v+1);
        }

        int oddCount = 0;
        for (Map.Entry<Integer, Integer> entry : degrees.entrySet()) {
            if(entry.getValue() %2 == 1){
                oddCount++;
            }
        }
        return oddCount == 0 || oddCount == 2;
    }



}
