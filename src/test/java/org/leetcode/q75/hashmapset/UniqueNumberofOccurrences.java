package org.leetcode.q75.hashmapset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberofOccurrences {

    /**
     * Given an array of integers arr,
     * return true if the number of occurrences of each value in the array is unique or false otherwise.
     */


    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int n : arr) {
            Integer count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if(set.contains(value)){
                return false;
            }
            set.add(value);
        }
        return true;
    }


}
