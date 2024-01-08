package org.leetcode.q75.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumAverageSubarrayI {

    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
     * Any answer with a calculation error less than 10-5 will be accepted.
     */

    @Test
    public void test(){
        Assertions.assertEquals(12.75d, findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        Assertions.assertEquals(3d, findMaxAverage(new int[]{4,2,1,3,3}, 2));
    }

    @Test
    public void test1(){
        Assertions.assertEquals(3d, findMaxAverage(new int[]{4,2,1,3,3}, 2));
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = nums[0];
        for(int i = 1; i < k; i++){
            sum += nums[i];
        }
        double max = sum/k;
        for(int i = k; i < nums.length; i++){
            sum += nums[i] - nums[i-k];
            max = Math.max(max, (sum)/k);
        }
        return max;
    }

}
