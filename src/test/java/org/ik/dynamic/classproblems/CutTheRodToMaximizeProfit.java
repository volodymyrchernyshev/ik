package org.ik.dynamic.classproblems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CutTheRodToMaximizeProfit {


    @Test
    public void test(){
        System.out.println(get_maximum_profit(new ArrayList<>(Arrays.asList(1, 5, 8, 9))));
    }

    static Integer get_maximum_profit(ArrayList<Integer> price) {
        // Write your code here.
        int n = price.size();

        return dp(n, price);
    }


    static int brutForce(int n, ArrayList<Integer> price){
        if(n <= 0){
            return 0;
        }
        int ret = 0;
        for(int i = 1; i <= n; i++){
            ret = Math.max(ret, price.get(i-1) + brutForce(n -i, price));
        }
        return ret;
    }


    static int dp(int n, ArrayList<Integer> price){
        int[] dp = new int[n+1];

        for(int i = 0; i <= n; i++){
            int current = dp[i];
            for(int j =0; i + j  < n ; j++){
                int persisted = dp[i + j + 1];
                int newValue = current + price.get(j);

                dp[i + j + 1] = Math.max(persisted, newValue);
            }
        }
        return dp[n];
    }
}
