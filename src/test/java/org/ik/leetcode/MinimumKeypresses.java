package org.ik.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MinimumKeypresses {

    @Test
    public void test() {
//        System.out.println(minimumKeypresses("apple"));
        System.out.println(minimumKeypresses("aaaaaaaabcdefgggghijkllllllllllmmmnoppponono"));

    }


    public int minimumKeypresses(String s) {


        Map<Character, Integer> freqMap = new TreeMap<>();
        for (char c : s.toCharArray()) {
            freqMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        List<Integer> freq = new ArrayList<>(freqMap.values());
        Collections.sort(freq, Collections.reverseOrder(Integer::compare));

        int ret = 0;

        for (int i = 0; i < freq.size(); i++) {
            ret += freq.get(i) * ((i+9) / 9);
        }

        return ret;
    }

}
