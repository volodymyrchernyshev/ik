package org.ik.dynamic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumCoins {


    @Test
    public void test(){
        System.out.println(minimum_coins(new ArrayList<>(Arrays.asList(1,3,5)), 9));
    }



    static Integer minimum_coins(ArrayList<Integer> coins, Integer value) {
        // Write your code here.
        int[] tab = new int[value +1];
        Arrays.fill(tab, -1);
        tab[0] = 0;

        for(int i = 0; i < tab.length - 1; i++){
            for (int coin : coins) {
                addCoin(tab, i, coin);
            }

        }

        return tab[value];
    }

    private static void addCoin(int[] tab, int i, int coin) {
        if(i + coin >= tab.length){
            return;
        }
        int coinCount = tab[i] + 1;
        if(tab[i + coin] == -1 || tab[i + coin] > coinCount){
            tab[i + coin] = coinCount;
        }
    }

}
