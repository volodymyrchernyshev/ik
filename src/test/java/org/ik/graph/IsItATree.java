package org.ik.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsItATree {


    @Test
    public void test(){
        System.out.println(is_it_a_tree(4, new ArrayList<>(Arrays.asList(0,0,0)), new ArrayList<>(Arrays.asList(1,2,3))));
        System.out.println(is_it_a_tree(4, new ArrayList<>(Arrays.asList(0,0)), new ArrayList<>(Arrays.asList(1,2))));
        System.out.println(is_it_a_tree(4, new ArrayList<>(Arrays.asList(0,0,1,2)), new ArrayList<>(Arrays.asList(3,1,2,0))));
        System.out.println(is_it_a_tree(4, new ArrayList<>(Arrays.asList(0,0,0,1)), new ArrayList<>(Arrays.asList(1,2,3,0))));
    }

    static Boolean is_it_a_tree(Integer n, ArrayList<Integer> edge_start, ArrayList<Integer> edge_end) {

        ArrayList<ArrayList<Integer>> adjancencyList = createAdjancencyList(edge_start, edge_end, n);


        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, Boolean.FALSE);

        if(isBFSHasCycles(adjancencyList, visited, 0)){
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

    private static boolean isBFSHasCycles(ArrayList<ArrayList<Integer>> adjacencyList, Boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            for (Integer next : adjacencyList.get(current)) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                } else {
                    return true;
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
//            ret.get(end.get(i)).add(start.get(i));
        }

        return ret;
    }


}
