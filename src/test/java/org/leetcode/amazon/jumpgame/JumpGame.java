package org.leetcode.amazon.jumpgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JumpGame {


    /**
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in
     * the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     */

    @Test
    public void test(){
        Assertions.assertTrue(canJump(new int[]{2,3,1,1,4}));
        Assertions.assertFalse(canJump(new int[]{3,2,1,0,4}));
        Assertions.assertTrue(canJump(new int[]{0}));
    }


    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length];

        int lastIndex = length - 1;
        for(int i = lastIndex; i>= 0; i--){
            int value = nums[i];
            int maxJump = value + i;
            if(maxJump >= lastIndex){
                dp[i] = true;
            } else {
                for(int j = i+1; j <= maxJump; j++){
                    if(dp[j]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        };
        return dp[0];
    }

}
