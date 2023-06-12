package org.ik.recursion;

import org.junit.jupiter.api.Test;

public class CountAllSubsets {

    @Test
    public void test1(){
        System.out.println(count_all_subsets(3));
    }



    static Integer count_all_subsets(Integer n) {

        if(n == 1){
            return 2;
        } else if(n == 2){
            return 2*2;
        }

        int k = n/2;
        int ret = count_all_subsets(k) * count_all_subsets(k);

        if(n%2 == 1){
            return 2 *  ret;
        }

        return ret;
    }

}
