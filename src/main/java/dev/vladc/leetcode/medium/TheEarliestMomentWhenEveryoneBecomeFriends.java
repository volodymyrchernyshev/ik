package dev.vladc.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;

public class TheEarliestMomentWhenEveryoneBecomeFriends {

    public int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        for (int[] log : logs) {
            System.out.println(Arrays.toString(log));

        }

        HashSet<Integer>[] friends = new HashSet[n];
        for(int i = 0; i < n; i++){
            friends[i] = new HashSet<>();
            friends[i].add(i);
        }

        for (int[] log : logs) {
            int f1 = log[1];
            int f2 = log[2];

            HashSet<Integer> f1Set =  friends[f1];
            HashSet<Integer> f2Set =  friends[f2];
            f1Set.addAll(f2Set);
            if(f1Set.size() == n){
                return log[0];
            } else {
                for(Integer f : f1Set){
                    friends[f].addAll(f1Set);
                }
            }

        }


        return -1;

    }

}
