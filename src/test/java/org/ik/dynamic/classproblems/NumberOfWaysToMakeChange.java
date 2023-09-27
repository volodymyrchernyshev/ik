package org.ik.dynamic.classproblems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfWaysToMakeChange {


    @Test
    public void test(){
        System.out.println(number_of_ways(new ArrayList<>(Arrays.asList(1,2,3)), 3) );
//        System.out.println(number_of_ways(new ArrayList<>(Arrays.asList(9, 1, 8, 10, 3)), 12) );
    }

    static Integer number_of_ways(ArrayList<Integer> coins, Integer amount) {
        // Write your code here.
        int[] dp = new int[amount +1];
        dp[0] = 1;

        for (Integer coin : coins) {
            for(int i = 1; i <= amount; i++){
                    if( coin <= i){
                        dp[i] = dp[i]%1000000007+dp[i-coin]%1000000007;
                    }
                }
        }
        return dp[amount]%1000000007;
    }


    static Integer number_of_ways2(ArrayList<Integer> coins, Integer amount) {
        // Write your code here.
        List[] dp = new List[amount +1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = new ArrayList();
        }

        for(int i = 0; i < amount; i++){
            //this will not work
            //wrong - we need to fill the same nomination till the end of the array!!!
            for (Integer coin : coins) {
                if( coin + i <= amount){
                    dp[coin + i].add(coin);
                }
            }
            System.out.println(i+ ": " + Arrays.toString(dp));
        }
        return dp[amount].size();
    }



}
