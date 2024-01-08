package org.leetcode.q75.prefixsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindPivotIndex {

    /**
     * Given an array of integers nums, calculate the pivot index of this array.
     * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
     * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
     * Return the leftmost pivot index. If no such index exists, return -1.
     */

    @Test
    public void test(){
        Assertions.assertEquals(3, pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    @Test
    public void test1(){
        Assertions.assertEquals(0, pivotIndex(new int[]{2,1,-1}));
    }

    public int pivotIndex(int[] nums) {
        return  pivotIndexOpt(nums);
    }

    private int pivotIndexOpt(int[] nums) {
        int right = 0;
        for (int n : nums) {
            right +=n;
        }
        right -= nums[0];
        int left = 0;
        if(left == right) {
            return 0;
        }
        for(int i = 1; i < nums.length; i++){
            left += nums[i -1];

            right -= nums[i];

            if(left == right){
                return i;
            }
        }

        return -1;
    }

    public int pivotIndexBrute(int[] nums) {
        int[] left = new int[nums.length +1];
        int[] right = new int[nums.length +1];
        left[0] = 0;
        for(int i = 2; i <= nums.length; i++){
            left[i] = left[i-1] + nums[i-1];
        }
        right[nums.length] = 0;
        for(int i = nums.length-1; i>=0; i--){
            right[i] = right[i+1] + nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            //index = i + 1;
            int l = left[i];
            int r = right[i + 1];
            if(l == r){
                return i;
            }
        }

        return -1;
    }

}
