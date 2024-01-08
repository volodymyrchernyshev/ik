package org.leetcode.q75.twopointers;

import org.junit.jupiter.api.Test;

public class MoveZeroes {

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     */

    @Test
    public void test(){
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{0});
    }

    public void moveZeroes(int[] nums) {

        for(int i = 0, j =0; i < nums.length; i++){
            if(nums[i] == 0){
                j++;
            } else if(j > 0){
                nums[i-j] = nums[i];
                nums[i] = 0;
            }
        }
    }

}
