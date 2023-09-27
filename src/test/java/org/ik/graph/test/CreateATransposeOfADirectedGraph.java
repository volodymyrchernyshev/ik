package org.ik.graph.test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CreateATransposeOfADirectedGraph {


    @Test
    public void test(){
        GraphNode node1 = new GraphNode(1);
        node1.neighbors = new ArrayList<>();
        GraphNode node2 = new GraphNode(2);
        node2.neighbors = new ArrayList<>();
        GraphNode node3 = new GraphNode(3);
        node3.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        create_transpose(node1);
    }



    @Test
    public void test2(){
        GraphNode node1 = new GraphNode(1);
        node1.neighbors = new ArrayList<>();
        GraphNode node2 = new GraphNode(2);
        node2.neighbors = new ArrayList<>();
        GraphNode node3 = new GraphNode(3);
        node3.neighbors = new ArrayList<>();

        GraphNode node4 = new GraphNode(4);
        node4.neighbors = new ArrayList<>();

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);
        create_transpose(node1);
    }


    static class GraphNode {
        Integer value;
        ArrayList<GraphNode> neighbors;

        GraphNode(Integer value) {
            this.value = value;
            this.neighbors = new ArrayList(3);
        }

        @Override
        public String toString() {
            return "GraphNode{" + "value=" + value + ", neighbors=" + neighbors.stream().map(g-> g.value).collect(Collectors.toList()) + '}';
        }
    }

    static GraphNode create_transpose(GraphNode node) {
        if(node == null || node.neighbors == null || node.neighbors.isEmpty()){
            return node;
        }

        // Write your code here.
        Map<Integer, List<Integer>> edgeList = new TreeMap<>();
        travel(edgeList, node, new HashSet<>());

//        Map<Integer, List<Integer>> reverse = reverse(edgeList);



        GraphNode root = new GraphNode(edgeList.keySet().iterator().next());
        root.neighbors = new ArrayList<>();

        createGraph(root, edgeList, new HashMap<>());


        return root;
    }

    private static void createGraph(GraphNode node, Map<Integer, List<Integer>> edges, Map<Integer, GraphNode> visited) {

        if(visited.containsKey(node.value)){
            return;
        }
        visited.put(node.value, node);

        for (Integer v : edges.get(node.value)) {
            GraphNode current;
            if(visited.containsKey(v)){
                current = visited.get(v);
            } else {
                current = new GraphNode(v);
                node.neighbors = new ArrayList<>();
                createGraph(current, edges, visited);
            }
            node.neighbors.add(current);
        }
    }

    private static void travel(Map<Integer, List<Integer>> edgeList, GraphNode node, Set<Integer> visited) {

        if(visited.contains(node.value)){
            return;
        }
        visited.add(node.value);

        System.out.println("Node " + node.value + " neighbors: " + node.neighbors.stream().map(g -> g.value).collect(Collectors.toList()));

        for (GraphNode neighbor : node.neighbors) {
            edgeList.compute(neighbor.value, (k,v) -> {
                if(v == null){
                    List<Integer> newV = new ArrayList<>();
                    newV.add(node.value);
                    return newV;
                }else {
                    v.add(node.value);
                    return v;
                }

            });
            travel(edgeList, neighbor, visited);
        }
    }


}

