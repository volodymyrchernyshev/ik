package org.leetcode.amazon.jumpgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class JumpGameV {

    /**
     * Given an array of integers arr and an integer d. In one step you can jump from index i to index:
     * i + x where: i + x < arr.length and  0 < x <= d.
     * i - x where: i - x >= 0 and  0 < x <= d.
     * In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k]
     * for all indices k between i and j (More formally min(i, j) < k < max(i, j)).
     *
     * You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
     * Notice that you can not jump outside of the array at any time.
     */

    @Test
    public void test(){
        //                                                      0 1 2  3 4 5  6 7 8  9 10
        Assertions.assertEquals(4, maxJumps(new int[] {6,4,14,6,8,13,9,7,10,6,12}, 2));
        Assertions.assertEquals(1, maxJumps(new int[] {3,3,3,3,3}, 3));
        Assertions.assertEquals(7, maxJumps(new int[] {7,6,5,4,3,2,1}, 1));
    }

    public int maxJumps(int[] arr, int d) {
        int[] memo = new int[arr.length];

        int ret = 0;
        for(int i = 0; i < arr.length; i++){
            ret = Math.max(ret, maxJumps(arr, d, i, memo));
        }
        return ret;
    }

    private int maxJumps(int[] arr, int d, int start, int[] memo) {
        if(memo[start] > 0){
            return memo[start];
        }

        int maxJumps = 1;
        for(int i = start + 1; i < arr.length && i <= start + d && arr[start] > arr[i]; i++){
            maxJumps = Math.max(maxJumps, maxJumps(arr, d, i, memo) + 1);
        }

        for(int i = start - 1; i >= 0 && i >= start - d && arr[start] > arr[i]; i--){
            maxJumps = Math.max(maxJumps, maxJumps(arr, d, i, memo) + 1);
        }

        memo[start]= maxJumps;
        return maxJumps;

    }
}
