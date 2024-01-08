package org.leetcode.q75.stringarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IncreasingTripletSubsequence {

    /**
     * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
     * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
     */

    @Test
    public void test(){
        Assertions.assertTrue(increasingTriplet(new int[]{1,2,3,4,5}));
        Assertions.assertFalse(increasingTriplet(new int[]{5,4,3,2,1}));
        Assertions.assertTrue(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
    @Test
    public void test1(){
        Assertions.assertTrue(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }


    public boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n <= first_num) {
                first_num = n;
            } else if (n <= second_num) {
                second_num = n;
            } else {
                return true;
            }
        }
        return false;
    }

//    public boolean increasingTriplet(int[] nums) {
//        if(nums.length <3){
//            return false;
//        }
//
//        int num1 = 0,num2 = 0,num3 = 0;
//        boolean num1Set = false, num2Set = false, num3Set = false;
//        for(int n : nums){
//
//            if(!num1Set){
//                num1 = n;
//                num1Set = true;
//                continue;
//            }
//            if(!num2Set){
//                if(n < num1){
//                    num1 = n;
//                    continue;
//                } else {
//                    num2 = n;
//                    num2Set = true;
//                    continue;
//                }
//            }
//            if(!num3Set){
//                if(n < num1){
//                    num1 = n;
//                    num2Set = false;
//                    continue;
//                } else if(n < num2){
//                    num2 = n;
//                    continue;
//                } else {
//                    return true;
//                }
//            }
//
//        }
//        return false;
//    }

}
