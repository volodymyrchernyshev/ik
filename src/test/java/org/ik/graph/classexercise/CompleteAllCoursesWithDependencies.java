package org.ik.graph.classexercise;

import java.util.ArrayList;
import java.util.Arrays;

public class CompleteAllCoursesWithDependencies {


    static Boolean can_be_completed(Integer n, ArrayList<Integer> start, ArrayList<Integer> end) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> list = createAdjancencyList(start, end, n);
        int[] dep = new int[n];
        Arrays.fill(dep, -1);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i = 0; i < visited.length; i++){

            if(!visited[i]){
                if(!canCompleteDFS(list, visited, dep, i)){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean canCompleteDFS(ArrayList<ArrayList<Integer>> list, boolean[] visited, int[] dep, int start) {

        visited[start] = true;
        dep[start] = 0;
        for (Integer child : list.get(start)) {
            if(!visited[child]){
                if(!canCompleteDFS(list, visited, dep, child)){
                    return false;
                }
            } else if(dep[child] == 0){
                return false;
            }
        }

        dep[start] = 1;
        return true;
    }


    private static ArrayList<ArrayList<Integer>> createAdjancencyList(ArrayList<Integer> start, ArrayList<Integer> end, Integer n) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        for(int i = 0; i < n; i++){
            ret.add(new ArrayList<>());
        }

        for(int i = 0; i < start.size(); i++){
            ret.get(start.get(i)).add(end.get(i));
//            ret.get(end.get(i)).add(start.get(i));//it's unidirectional graph
        }

        return ret;
    }

}
