package org.leetcode.amazon.jumpgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class JumpGameII {


    /**
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
     * Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
     * if you are at nums[i], you can jump to any nums[i + j] where:
     *0 <= j <= nums[i] and i + j < n
     * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     */

    @Test
    public void test(){
        Assertions.assertEquals(2, jump(new int[]{2,3,1,1,4}));
        Assertions.assertEquals(2, jump(new int[]{2,3,0,1,4}));
    }

    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, nums.length);

        int lastI = nums.length -1;
        dp[lastI] = 0;

        for(int i = lastI -1; i >= 0; i--){
            int maxJump = i + nums[i];

            if(maxJump >= lastI){
                dp[i] = 1;
            } else{
                int min = nums.length;
                for(int j = i+1; j <= maxJump; j++){
                    min = Math.min(min, dp[j]);
                }
                dp[i] = min +1;
            }
        }
        return dp[0];
    }


}

