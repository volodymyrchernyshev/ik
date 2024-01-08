package org.leetcode.q75.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerWithMostWater {

    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
     * of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     * Notice that you may not slant the container.
     */

    @Test
    public void test(){
        Assertions.assertEquals(49, maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        Assertions.assertEquals(1, maxArea(new int[] {1,1}));
    }

    public int maxArea(int[] height) {
        int max = 0;
        for(int i =0, j = height.length -1; i < j;){
            max = Math.max(max, Math.min(height[i], height[j]) * (j -i));
            if(height[i] > height[j]){
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

}
