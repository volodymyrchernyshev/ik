package org.ik.dynamic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MinCostClimbingStairs {


    @Test
    public void test(){
        System.out.println(min_cost_climbing_stairs(new ArrayList<>(Arrays.asList(1,1,2))));
    }

    static Integer min_cost_climbing_stairs(ArrayList<Integer> cost) {
        // Write your code here.
        if(cost == null || cost.size() < 2){
            return 0;
        }

        int tab[] = new int[cost.size() +2];
        tab[0] = 0;
        tab[1] = cost.get(0);
        cost.add(0);

        for(int i = 2; i <= cost.size(); i++){
            tab[i] = Math.min(tab[i-1], tab[i -2]) + cost.get(i-1);
        }

        return  tab[tab.length -1];
    }

}
