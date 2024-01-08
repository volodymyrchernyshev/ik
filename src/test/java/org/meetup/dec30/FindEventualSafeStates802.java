package org.meetup.dec30;

import org.junit.jupiter.api.Test;

import java.util.*;

public class FindEventualSafeStates802 {

    /**
     * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
     *
     * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
     *
     * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
     */

    @Test
    public void test(){
        System.out.println(topologicalSort(new int[][]{new int[]{1,2}, new int[]{2,3}, new int[]{5}, new int[]{0}, new int[]{5}, new int[]{}, new int[]{} }));
        System.out.println(dfsColors(new int[][]{new int[]{1,2}, new int[]{2,3}, new int[]{5}, new int[]{0}, new int[]{5}, new int[]{}, new int[]{} }));
        System.out.println(dfs(new int[][]{new int[]{1,2}, new int[]{2,3}, new int[]{5}, new int[]{0}, new int[]{5}, new int[]{}, new int[]{} }));
    }
    public List<Integer> topologicalSort(int[][] graph) {

        List<List<Integer>> aList = new ArrayList<>();
        int[] degree = new int[graph.length];

        for( int i = 0; i < graph.length; i++){
            aList.add(new ArrayList<>());
        }

        for( int i = 0; i < graph.length; i++){
            for(int node : graph[i]){
                aList.get(node).add(i);
                degree[i]++;
            }

        }
        Queue<Integer> q = new LinkedList<>();
        for (int i =0; i < graph.length; i++) {
            if(degree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ret.add(node);
            for(int neighbor : aList.get(node)){
                degree[neighbor]--;
                if(degree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }

        Collections.sort(ret);

        return ret;
    }

    public List<Integer> dfsColors(int[][] graph) {
        int[] colors = new int[graph.length];
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0 ; i < graph.length; i++){
            if(dfsColors(graph, colors, i)){
                ret.add(i);
            }
        }


        return ret;
    }

    private boolean dfsColors(int[][] graph, int[] colors, int node) {
        if(colors[node] > 0){
            return colors[node] == 2;
        }
        colors[node] = 1;

        for(int child : graph[node]){
            if(!dfsColors(graph, colors, child)){
                return false;
            }
        }

        colors[node] = 2;
        return true;
    }

    public List<Integer> dfs(int[][] graph) {
    boolean[] unsafe = new boolean[graph.length];
    boolean[] safe = new boolean[graph.length];
    boolean[] added = new boolean[graph.length];
    List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
        int[] node = graph[i];
        if(node == null || node.length == 0){
            if(!added[i]){
                ret.add(i);
                added[i] = true;
                safe[i] = true;
            }
        } else {
            if(dfs(graph, i, new boolean[graph.length], new boolean[graph.length], unsafe, safe) && !ret.contains(i)){
                ret.add(i);
            }
        }
    }

        return ret;
}

    private boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] returned, boolean[] unsafe, boolean[] safe){
        if(safe[node]){
            return true;
        }

        if(unsafe[node]){
            return false;
        }

        if(visited[node] && !returned[node]){
            unsafe[node] = true;
            return false;
        }

        visited[node] = true;
        int[] g = graph[node];

        for(int i = 0; i < g.length; i++){
            if(safe[g[i]]){
                //do nothing
            } if(!dfs(graph, g[i], visited, returned, unsafe, safe)){
                unsafe[g[i]] = true;
                return false;
            } else {
                safe[g[i]] = true;
            }
        }
        returned[node] = true;
        safe[node] = true;
        return true;

    }

}
