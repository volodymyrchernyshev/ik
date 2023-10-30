package org.leetcode.q75.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    /**
     * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * Return a list of all possible valid combinations. The list must not contain the same combination twice,
     * and the combinations may be returned in any order.
     */

    @Test
    public void test(){
        System.out.println(combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();

        combinationSum(0, 1, 0, k, n, ret, new ArrayList<>());

        return ret;
    }

    public void combinationSum(int i, int next, int sum, int k, int n, List<List<Integer>> ret, List<Integer> slate) {
        if(i >= k){
            if(n == sum){
                ret.add(new ArrayList<>(slate));
            }
            return;
        }
        for(int j = next; j < 10; j++){
            slate.add(j);
            sum += j;
            if(sum <= n){
                combinationSum(i+1, j +1, sum, k, n, ret, slate);
            }
            slate.remove(slate.size()-1);
            sum -= j;
        }
    }


}
