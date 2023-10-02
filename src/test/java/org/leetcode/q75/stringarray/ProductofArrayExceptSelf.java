package org.leetcode.q75.stringarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product
     * of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     */

    @Test
    public void test(){
        Assertions.assertTrue(Arrays.equals(new int[]{24,12,8,6}, productExceptSelf(new int[]{1,2,3,4})));
        Assertions.assertTrue(Arrays.equals(new int[]{0,0,9,0,0}, productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int p = 1;
        int zeros = 0;
        for (int num : nums) {
            if(num == 0){
                zeros ++;
            } else {
                p *= num;
            }
        }

        int[] ret = new int[nums.length];

        if(zeros > 1) {
            return ret;
        } else if(zeros == 1){

            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    ret[i] = 0;
                } else {
                    ret[i] = p;
                }
            }
        } else {
            for(int i = 0; i < nums.length; i++){
                ret[i] = p /nums[i];
            }
        }
        return ret;
    }

}
