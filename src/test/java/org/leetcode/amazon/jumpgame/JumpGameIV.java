package org.leetcode.amazon.jumpgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class JumpGameIV {

    /**
     * Given an array of integers arr, you are initially positioned at the first index of the array.
     * In one step you can jump from index i to index:
     * i + 1 where: i + 1 < arr.length.
     * i - 1 where: i - 1 >= 0.
     * j where: arr[i] == arr[j] and i != j.
     * Return the minimum number of steps to reach the last index of the array.
     * Notice that you can not jump outside of the array at any time.
     */

    @Test
    public void test(){
        Assertions.assertEquals(3, minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
        Assertions.assertEquals(0, minJumps(new int[]{7}));
        Assertions.assertEquals(1, minJumps(new int[]{7,6,9,6,9,6,9,7}));
    }


    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> jMap = new HashMap<>();
        for(int i =0; i < arr.length; i++){
            List<Integer> js = jMap.computeIfAbsent(arr[i], (k) -> new ArrayList<>());
            js.add(i);
        }

        boolean[] visited = new boolean[arr.length];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int ret = 0;
        while(!q.isEmpty()){

            int size = q.size();
            for(int i = 0; i < size; i++){
                int index = q.poll();

                if(index == arr.length -1){
                    return ret;
                }

                if(visited[index]){
                    continue;
                }
                visited[index] = true;

                int value = arr[index];
                if(jMap.containsKey(value)) {
                    for (Integer j : jMap.get(value)) {
                        q.add(j);
                    }
                    //VERY IMPORTANT. this prevents to go bacward.
                    jMap.remove(value);
                }
                if(index + 1 < arr.length){
                    q.add(index +1);
                }
                if(index - 1 > 0){
                    q.add(index -1);
                }

            }
            ret++;
        }

        return -1;
    }

}
