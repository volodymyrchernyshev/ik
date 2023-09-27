package org.leetcode.amazon.jumpgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    /**
     * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
     * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
     *
     * Notice that you can not jump outside of the array at any time.
     */

    @Test
    public void test(){
        Assertions.assertTrue(canReach(new int[]{4,2,3,0,3,1,2}, 5));
        Assertions.assertTrue(canReach(new int[]{4,2,3,0,3,1,2}, 0));
        Assertions.assertFalse(canReach(new int[]{3,0,2,1,2}, 2));
    }


    public boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        boolean[] visited = new boolean[arr.length];

        while(!q.isEmpty()){
            Integer i = q.poll();
            int value = arr[i];
            if(value == 0){
                return true;
            }
            if(visited[i]){
                continue;
            }
            visited[i] = true;

            if(value + i < arr.length){
                q.add(value + i);
            }
            if(i - value >= 0){
                q.add(i - value);
            }


        }

        return false;
    }

}
