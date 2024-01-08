package org.leetcode.q75.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class MaximumSubsequenceScore {

    /**
     * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k.
     * You must choose a subsequence of indices from nums1 of length k.
     *
     * For chosen indices i0, i1, ..., ik - 1, your score is defined as:
     *
     * The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
     * It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
     * Return the maximum possible score.
     *
     * A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1}
     * by deleting some or no elements.
     */

    @Test
    public void test(){
        Assertions.assertEquals(12, maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4},  3));
    }


    public long maxScore(int[] nums1, int[] nums2, int k) {
        long sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
            sum += nums1[i];
            queue.add(nums2[i]);
        }

        long ret = sum * queue.poll();

        for(int i = k; i < nums1.length; i++){
            sum -= nums1[i - k];
            queue.remove(nums2[i - k]);
            sum += nums1[i];
            queue.add(nums2[i]);
            ret = Math.max(ret, sum * queue.poll());
        }

        return ret;
    }

}
