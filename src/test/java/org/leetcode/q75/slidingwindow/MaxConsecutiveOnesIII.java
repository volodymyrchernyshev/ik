package org.leetcode.q75.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnesIII {

    /**
     * Given a binary array nums and an integer k,
     * return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     */

//    @Test
//    public void test(){
//        Assertions.assertEquals(6, longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
//    }

    @Test
    public void test(){
        Assertions.assertEquals(10, longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }


    public int longestOnes(int[] nums, int k) {

        int max = k;
        for(int i =0, j=0, count =0; j < nums.length;){
           while(j < nums.length && (count < k || nums[j] == 1)){
               if(nums[j] == 0){
                   count++;
               }
               j++;
           }
           max = Math.max(max, j - i);
           while(count == k && i < nums.length){
               if(nums[i] == 0){
                   count--;
               }
               i++;
           }
        }
        return max;

    }

    public int longestOnesOptimized(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }

}
