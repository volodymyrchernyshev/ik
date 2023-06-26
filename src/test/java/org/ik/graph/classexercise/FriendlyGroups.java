package org.ik.graph.classexercise;

import java.util.*;

public class FriendlyGroups {

    static Boolean can_be_divided(Integer n, ArrayList<Integer> dislike1, ArrayList<Integer> dislike2) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> list = createAdjancencyList(dislike1, dislike2, n);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int[] colors = new int[n];
        Arrays.fill(colors, 0);

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(!canBeDividedBfs(list, i, visited, colors)){
                    return false;
                }
            }
        }


        return true;
    }

    private static boolean canBeDividedBfs(ArrayList<ArrayList<Integer>> list, int start, boolean[] visited, int[] colors) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1;
        while(!queue.isEmpty()){
            int current = queue.poll();
            int currentColor = colors[current];
            visited[current] = true;
            for (Integer child : list.get(current)) {
                if(!visited[child]){
                    colors[child] = -1 * currentColor;
                    queue.add(child);
                } else if(colors[child] == currentColor){
                    return false;
                }
            }
        }
        return true;
    }


    private static ArrayList<ArrayList<Integer>> createAdjancencyList(ArrayList<Integer> start, ArrayList<Integer> end, Integer n) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        for(int i = 0; i < n; i++){
            ret.add(new ArrayList<>());
        }

        for(int i = 0; i < start.size(); i++){
            ret.get(start.get(i)).add(end.get(i));
            ret.get(end.get(i)).add(start.get(i));//it's unidirectional graph
        }

        return ret;
    }

}
