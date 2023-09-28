package org.ik.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermuteArrayOfUniqueIntegers {

    @Test
    public void test(){
        //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
        System.out.println(get_permutations(new ArrayList<>(List.of(1,2,3))));
    }

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        get_permutations(ret, arr, 0);
        return ret;
    }

    private static void get_permutations(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> arr, int start) {
        //base case
        if(start == arr.size()){
            ret.add(new ArrayList<>(arr));
        }
        for(int i = start; i < arr.size(); i++){
            Collections.swap(arr, i, start);//permutate
            get_permutations(ret, arr, start +1);//recursive call
            Collections.swap(arr, i, start);//rollback
        }
    }

}
