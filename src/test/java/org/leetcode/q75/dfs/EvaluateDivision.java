package org.leetcode.q75.dfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class EvaluateDivision {

    /**
     * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi]
     * and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
     * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find
     * the answer for Cj / Dj = ?.
     * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
     * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero
     * and that there is no contradiction.
     * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
     */

    @Test
    public void test(){
        Assertions.assertEquals(1, 1);
    }

    static class Pair{

        String key;
        double value;
        public Pair(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adjMap = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> eq = equations.get(i);
            adjMap.computeIfAbsent(eq.get(0), (k)  -> new ArrayList<>()).add(new Pair(eq.get(1), values[i]));
            adjMap.computeIfAbsent(eq.get(1), (k)  -> new ArrayList<>()).add(new Pair(eq.get(0), 1/values[i]));
        }

        double[] ret = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            if(!adjMap.containsKey(query.get(0)) || !adjMap.containsKey(query.get(1))){
                ret[i] = -1;
            } else if(query.get(0).equals(query.get(1))){
                ret[i] = 1;
            } else {
                ret[i] = find(query.get(0), query.get(1), adjMap, 1d, new HashSet<String>());
            }
        }
        return ret;
    }

    private double find(String s, String s1, Map<String, List<Pair>> adjMap, double start, Set<String> visited) {
        visited.add(s);
        List<Pair> pairs = adjMap.get(s);
        for (Pair pair : pairs) {
            if(pair.key.equals(s1)){
                return start * pair.value;
            }
        }
        for (Pair pair : pairs) {
            if(visited.contains(pair.key)){
                continue;
            }
            double ret = find(pair.key, s1, adjMap, start * pair.value, visited);
            if(ret != -1){
                return ret;
            }
        }
        visited.remove(s);
        return -1;
    }

}
