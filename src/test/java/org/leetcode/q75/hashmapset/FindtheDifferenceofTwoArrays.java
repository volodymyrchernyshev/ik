package org.leetcode.q75.hashmapset;

import org.junit.jupiter.api.Test;

import java.util.*;

public class FindtheDifferenceofTwoArrays {

    /**
     * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
     *
     * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
     * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
     * Note that the integers in the lists may be returned in any order.
     */

    @Test
    public void test(){
        System.out.println(findDifference(new int[]{1,2,3}, new int[]{2,4,6}));

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List list1 = findNotPresent(nums1, nums2);
        List list2 = findNotPresent(nums2, nums1);
        return Arrays.asList(list1, list2);
    }

    private List findNotPresent(int[] nums1, int[] nums2) {

        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }
        Set<Integer> ret = new HashSet<>();
        for (int n : nums1) {
            if(!set2.contains(n)){
                ret.add(n);
            }
        }
        return new ArrayList<>(ret);
    }


}
