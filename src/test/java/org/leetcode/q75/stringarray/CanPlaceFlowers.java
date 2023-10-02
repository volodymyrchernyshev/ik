package org.leetcode.q75.stringarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanPlaceFlowers {

    /**
     * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
     *
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
     * return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
     */

    @Test
    public void test(){
//        Assertions.assertTrue(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
//        Assertions.assertFalse(canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        Assertions.assertTrue(canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));

    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i =0; i< flowerbed.length; i++){

            if(flowerbed[i] == 1){
                i++;
                continue;
            }

            if(i > 0 && flowerbed[i-1] == 1){
                continue;
            }
            if(i+1 < flowerbed.length && flowerbed[i+1] ==1){
                i++;
                continue;
            }
            n--;
            flowerbed[i] = 1;
            if(n == 0){
                return true;
            }
        }
        return n <=0;
    }

}
