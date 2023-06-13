package org.ik.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NChooseKCombinations {



    @Test
    public void test(){
        System.out.println(find_combinations(5, 2));
    }

    @Test
    public void test2(){
        System.out.println(find_combinations_new(5, 2));
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

    static ArrayList<ArrayList<Integer>> find_combinations_new(Integer n, Integer k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        find_comb_int(ret, new ArrayList<>(), 0, k, 0, n);

        return ret;
    }

    static void find_comb_int(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> current,  int previous, Integer k, int index, int n){

        if(k == index){
            ret.add(current);
            return;
        }

        for(int i = previous+1; i <=n; i++){
            ArrayList<Integer> newSequence = new ArrayList<Integer>(current);
            newSequence.add(i);
            find_comb_int(ret, newSequence, i, k, index +1, n);
        }
    }

}
