package org.ik.graph.foundation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.*;

public class IsItATree {


    @Test
    public void test(){
        Assertions.assertTrue(is_it_a_tree(4, new ArrayList<>(Arrays.asList(0,0,0)), new ArrayList<>(Arrays.asList(1,2,3))));
        Assertions.assertFalse(is_it_a_tree(4, new ArrayList<>(Arrays.asList(0,0)), new ArrayList<>(Arrays.asList(1,2))));
        Assertions.assertFalse(is_it_a_tree(4, new ArrayList<>(Arrays.asList(0,0,1,2)), new ArrayList<>(Arrays.asList(3,1,2,0))));
        Assertions.assertFalse(is_it_a_tree(4, new ArrayList<>(Arrays.asList(0,0,0,1)), new ArrayList<>(Arrays.asList(1,2,3,0))));
        Assertions.assertTrue(is_it_a_tree(6, new ArrayList<>(Arrays.asList(4,4,4,2,1)), new ArrayList<>(Arrays.asList(3,5,0,0,0))));
    }

    static Boolean is_it_a_tree(Integer n, ArrayList<Integer> edge_start, ArrayList<Integer> edge_end) {

        ArrayList<ArrayList<Integer>> adjancencyList = createAdjancencyList(edge_start, edge_end, n);

        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, Boolean.FALSE);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        if(isBFSHasCycles(adjancencyList, visited, 0, parent)){
            return false;
        }

        for (int i = 0; i < n; i++) {
            Boolean visit = visited[i];
            if(!visit){
                return false;
            }
        }

        return true;
    }

    private static boolean isBFSHasCycles(ArrayList<ArrayList<Integer>> adjacencyList, Boolean[] visited, int start, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for (Integer child : adjacencyList.get(current)) {
                if(!visited[child]) {
                    parent[child] = current;
                    queue.add(child);
                    visited[child] = true;
                } else {
                    if(child != parent[current]){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private static ArrayList<ArrayList<Integer>> createAdjancencyList(ArrayList<Integer> start, ArrayList<Integer> end, Integer n) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        for(int i = 0; i < n; i++){
            ret.add(new ArrayList<>());
        }

        for(int i = 0; i < start.size(); i++){
            ret.get(start.get(i)).add(end.get(i));
            ret.get(end.get(i)).add(start.get(i));
        }

        return ret;
    }


}
