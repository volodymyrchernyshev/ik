package org.ik.graph.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FindOrderOfCharactersInAlienDictionary {

    @Test
    public void test() {
        System.out.println(find_order(new ArrayList<>(Arrays.asList("baa", "abcd", "abca", "cab", "cad"))));
    }

    static String find_order(ArrayList<String> words) {
        // Write your code here.


        return "";
    }


    public static void addEdge(ArrayList<Integer>[] adj, char u, char v) {
        adj[u - 'a'].add(v - 'a');
    }

    public static void topologicalSortUtil(ArrayList<Integer>[] adj, int u, boolean[] visited, Stack<Integer> st) {
        visited[u] = true;

        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (!visited[v]) {
                topologicalSortUtil(adj, v, visited, st);
            }
        }

        st.push(u);
    }

    public static void topologicalSort(ArrayList<Integer>[] adj, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(adj, i, visited, st);
            }
        }

        while (!st.empty()) {
            System.out.print((char) (st.pop() + 'a') + " ");
        }
    }

    public static void printOrder(String[] words, int n, int k) {
        ArrayList<Integer>[] adj = new ArrayList[k];

        for (int i = 0; i < k; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int j = 0;
            while (j < word1.length() && j < word2.length()) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    addEdge(adj, word1.charAt(j), word2.charAt(j));
                    break;
                }
                j++;
            }
        }

        topologicalSort(adj, k);
    }

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        int n = words.length;
        int k = 4;

        printOrder(words, n, k);
    }


}
