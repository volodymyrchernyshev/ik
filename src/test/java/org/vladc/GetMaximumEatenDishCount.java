package org.vladc;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GetMaximumEatenDishCount {


    @Test
    public void test(){
//        System.out.println(getMaximumEatenDishCount(6, new int[]{1,2,3,3,2,1}, 1));
        System.out.println(getMaximumEatenDishCount(6, new int[]{1,2,3,3,2,1}, 2));
//        System.out.println(getMaximumEatenDishCount(7, new int[]{1,2,1,2,1,2,1}, 2));
    }

    public int getMaximumEatenDishCount(int N, int[] D, int K) {
        // Write your code here

        LinkedList<Integer> previous = new LinkedList<>();
        Set<Integer> previousSet = new HashSet<>();
        int ret = 0;

        for(int i = 0; i < N; i++){
            int dish = D[i];
            if(previous.contains(dish)){

            } else {
                previous.add(dish);
                ret++;
            }

            if(previous.size() > K){
                previous.removeFirst();
            }

        }

        return ret;
    }

}
