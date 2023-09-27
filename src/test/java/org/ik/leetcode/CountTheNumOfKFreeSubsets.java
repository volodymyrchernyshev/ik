package org.ik.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class CountTheNumOfKFreeSubsets {


    @Test
    public void test(){
        System.out.println(countTheNumOfKFreeSubsets(new int[]{5,4,6}, 1));
    }

    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            int curr = map.getOrDefault(x-k, 0);
            map.remove(x-k);
            map.put(x, curr +1);
        }


        HashMap<Integer,Long> memo = new HashMap<>();
        memo.put(0, 0L);
        memo.put(1, 1L);
        memo.put(2, 1L);
        memo.put(3, 2L);
        memo.put(4, 3L);
        memo.put(5, 5L);

        long res = 1L;
        for(int x : map.values()){
            res *= fib(x + 2, memo);
        }
        return res;
    }



    // we use memoization to save time processing for large cases
    public long fib(int n, HashMap<Integer,Long> memo){
        //    if(n <= 1) return n;
        //    else{
        //        return fib(n-1)+fib(n-2);
        //    }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        long fibValue;
        if(n <= 1) fibValue =n;
        else{
            fibValue = fib(n-1, memo)+fib(n-2, memo);
        }
        memo.put(n, fibValue);
        return fibValue;
    }

}
