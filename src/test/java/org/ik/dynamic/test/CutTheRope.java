package org.ik.dynamic.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CutTheRope {


    @Test    static Long max_product_from_cut_pieces(Integer n) {
        // Write your code here.
        Map<Long, Long> cache = new HashMap<>();
        cache.put(0L, 0L);
        cache.put(1L, 1L);
        return cut(n, 1, cache);
    }

    static long cut(long n, long cut, Map<Long, Long> cache) {
        Long cached = cache.get(n);
        if(cut == 0 && cached != null){
            return cached;
        }

        long max = 0;

        for(long i = cut; i < n; i++){
            if(i == 0){
                max = Math.max(max, n);
            } else {
                max = Math.max(max, i * cut(n - i, 0, cache));
            }
        }
        cache.put(n, max);
        return max;
    }
    public void test(){
        System.out.println(max_product_from_cut_pieces(4));
    }





}
