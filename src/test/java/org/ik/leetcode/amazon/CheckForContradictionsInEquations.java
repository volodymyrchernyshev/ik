package org.ik.leetcode.amazon;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CheckForContradictionsInEquations {


    @Test
    public void test() {
        System.out.println(checkContradictions(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("a", "c")),
                new double[]{3d, 0.5d, 1.5d}));
    }


    static class Node{
        String name;
        double value;

        public Node(String name, double value) {
            this.name = name;
            this.value = value;
        }
    }

    public boolean checkContradictions(List<List<String>> equations, double[] values) {

        Map<String, List<Node>> aMap = new HashMap<>();

        for (int i =0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            double value = values[i];
            String a = e.get(0);
            String b = e.get(1);
            List<Node> nodes = aMap.getOrDefault(a, new ArrayList<>());
            nodes.add(new Node(b, value));

            List<Node> reverse = aMap.getOrDefault(b, new ArrayList<>());
            reverse.add(new Node(a, 1/value));
        }

        Set<String> visited = new HashSet<>();
        for (String node : aMap.keySet()) {
            if(travel(node, aMap, visited)){
                return true;
            }
        }

        return false;
    }

    private boolean travel(String node, Map<String, List<Node>> aMap, Set<String> visited) {
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);

        for (Node child : aMap.get(node)) {
            if(travel(child.name, aMap, visited)){
                return true;
            }
        }

        return false;
    }


}
