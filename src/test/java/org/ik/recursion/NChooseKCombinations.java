package org.ik.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NChooseKCombinations {



    @Test
    public void test(){
        System.out.println(find_combinations(5, 2));
    }


    static ArrayList<ArrayList<Integer>> find_combinations(Integer n, Integer k) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            ArrayList<Integer> ar1 = new ArrayList<>();
            ar1.add(i);
            for(int j = i+1; j <=n; j++){
                ArrayList<Integer> ar2 = new ArrayList<>(ar1);
                ar2.add(j);
                ret.add(ar2);
            }

        }

        return ret;
    }


}
