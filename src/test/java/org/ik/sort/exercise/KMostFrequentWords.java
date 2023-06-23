package org.ik.sort.exercise;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class KMostFrequentWords {

    @Test
    public void test() {

        System.out.println(k_most_frequent(4, new ArrayList<>(Arrays.asList("car", "bus", "taxi", "car", "driver", "candy", "race", "car", "driver", "fare", "taxi"))));

    }


    static ArrayList<String> k_most_frequent(Integer k, ArrayList<String> words) {

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.compute(word, (key, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }

        Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        Comparator<Map.Entry<String, Integer>> reversed = comparator.reversed().thenComparing(Map.Entry::getKey);

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(count.size()+1, reversed);
        pq.addAll(count.entrySet());

        ArrayList<String> ret = new ArrayList();
        for(int i= 0; i<k; i++){
            ret.add(pq.poll().getKey());
        }
        return ret;
    }
}