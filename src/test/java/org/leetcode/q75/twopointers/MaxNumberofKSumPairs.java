package org.leetcode.q75.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPairs {

    /**
     * You are given an integer array nums and an integer k.
     * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
     * Return the maximum number of operations you can perform on the array.
     */

    @Test
    public void test(){
        Assertions.assertEquals(2, maxOperations(new int[]{1,2,3,4}, 5));
    }

    public int maxOperations(int[] nums, int k) {
        return maxOperationsSort(nums, k);
    }
    public int maxOperationsHashMap(int[] nums, int k) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {

            int v = k - n;
            if(map.getOrDefault(v, 0) > 0){
                ret++;
                map.put(v, map.get(v) -1);
            } else {
                map.compute(n, (key,value) -> value == null ? 1 : value + 1);
            }
        }
        return ret;
    }

    public int maxOperationsSort(int[] nums, int k) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i = 0, j = nums.length -1; i < j;){
            int v = nums[i] + nums[j];
            if(v == k){
                ret++;
                i++;
                j--;
            } else if(v > k){
                j--;
            } else {
                i++;
            }
        }
        return ret;
    }
}
