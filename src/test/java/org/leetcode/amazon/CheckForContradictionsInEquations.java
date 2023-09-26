package org.leetcode.amazon;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CheckForContradictionsInEquations {


    @Test
    public void test(){
        System.out.println(checkContradictions(Arrays.asList(Arrays.asList("a","b"),Arrays.asList("b","c"),Arrays.asList("a","c")),
                new double[]{3d, 0.5d ,1.5d}));
    }


    static class Pair{
        String name;
        double value;

        public Pair(String name, double value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" + "name='" + name + '\'' + ", value=" + value + '}';
        }
    }

    public boolean checkContradictions(List<List<String>> equations, double[] values) {

        Map<String, List<Pair>> eMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            eMap.computeIfAbsent(eq.get(0), (k) -> new ArrayList<>()).add(new Pair(eq.get(1), values[i]));
            eMap.computeIfAbsent(eq.get(1), (k) -> new ArrayList<>()).add(new Pair(eq.get(0), 1/values[i]));
        }

        //eMap is an adjacency map where key is left part of an equations and the value is
        // the pair of right part of an equation and value... and reverse equation too (1/value)


        Map<String, Double> visited = new HashMap<>();
        //visited is a map of visited node and the value is a calculated value.
        // If we have different value for a node while traveling the graph - we have a contradiction.

        for (String node : eMap.keySet()) {
            //we need to start only 1 node of a connected graph.
            //DFS the graph
            if(!visited.containsKey(node) && travelGraph(node, eMap, visited, 1d)){
                return true;
            }
        }
         return false;
    }

    private boolean travelGraph(String node, Map<String, List<Pair>> eMap, Map<String, Double> visited, double value) {
        if(visited.containsKey(node)){
            //Check if newly calculated value is the same as old one.
            return Math.abs(visited.get(node) - value) >= 0.00001d;
        }
        visited.put(node, value);

        for (Pair child : eMap.get(node)) {
            //DFS the graph
            if(travelGraph(child.name, eMap, visited, value * child.value)){
                return true;
            }
        }

        return false;
    }

}
