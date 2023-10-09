package org.leetcode.q75.dfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {

    /**
     * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between
     * two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads
     * in one direction because they are too narrow.
     * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
     * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
     * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number
     * of edges changed.
     * It's guaranteed that each city can reach city 0 after reorder.
     */

    @Test
    public void test(){
        Assertions.assertEquals(3, minReorderMaps(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
        Assertions.assertEquals(3, minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }


    public int minReorder(int n, int[][] connections) {

        ArrayList<Integer>[] adjMapTo = new ArrayList[n];
        fill(adjMapTo);
        ArrayList<Integer>[] adjMapFrom = new ArrayList[n];
        fill(adjMapFrom);
        for(int[] con : connections){
            adjMapTo[con[1]].add(con[0]);
            adjMapFrom[con[0]].add(con[1]);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        int count = 0 ;
        queue.add(0);
        while(!queue.isEmpty()){
            Integer city = queue.poll();
            if(visited[city]){
                continue;
            }
            visited[city] = true;
            for(Integer nb : adjMapTo[city]){
                queue.add(nb);
            }

            for(Integer nb : adjMapFrom[city]){
                if(!visited[nb]){
                    count++;
                    queue.add(nb);
                }
            }
        }

        return count;
    }

    private void fill(ArrayList<Integer>[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList();
        }
    }

    public int minReorderMaps(int n, int[][] connections) {

        Map<Integer, List<Integer>> adjMapTo = new HashMap<>();
        Map<Integer, List<Integer>> adjMapFrom = new HashMap<>();
        for(int[] con : connections){
            List<Integer> c0 = adjMapTo.computeIfAbsent(con[1], ArrayList::new);
            c0.add(con[0]);
            List<Integer> c1 = adjMapFrom.computeIfAbsent(con[0], ArrayList::new);
            c1.add(con[1]);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        int count = 0 ;
        queue.add(0);
        while(!queue.isEmpty()){
            Integer city = queue.poll();
            if(visited[city]){
                continue;
            }
            visited[city] = true;
            for(Integer nb : adjMapTo.getOrDefault(city, Collections.emptyList())){
                queue.add(nb);
            }

            for(Integer nb : adjMapFrom.getOrDefault(city, Collections.emptyList())){
                if(!visited[nb]) {
                    count++;
                    queue.add(nb);
                }
            }
        }

        return count;
    }

}
