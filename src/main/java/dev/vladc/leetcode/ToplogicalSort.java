package dev.vladc.leetcode;

import java.util.*;

public class ToplogicalSort {
    public static void main(String[] args) {System.out.println(new ToplogicalSort().sort(new int[][]{{2, 1}, {2, 3}}, 3));}
    /** Graph travel from leafs to root(s);
     * @param fromTo - values are 1 - k
     * @param k - number of vertexes */
    public List<Integer> sort(int[][] fromTo, int k){
        //making aList and counts
        ArrayList<Integer>[] aList = new ArrayList[k];
        int[] counts = new int[k];
        for(int i = 0; i < k ; i++){
            aList[i] = new ArrayList<>();
        }

        for(int[] c : fromTo){
            int from = c[0], to = c[1];
            aList[from-1].add(to);
            counts[to-1]++;
        }
        //putting all the leafs (counts[i]==0) to queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < k; i++){
            if(counts[i] == 0){
                q.add(i+1);
            }
        }
        List<Integer> ret = new ArrayList<>();
        //iterating from leafs to root
        while(!q.isEmpty()){
            Integer v = q.poll();
            ret.add(v);
            ArrayList<Integer> next = aList[v - 1];
            for (Integer n : next) {
                counts[n - 1]--;
                if (counts[n - 1] == 0) {
                    q.add(n);
                }
            }
        }
        Collections.reverse(ret);
        return ret;
    }
}
