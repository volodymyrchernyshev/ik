package org.vladc;

import org.junit.jupiter.api.Test;
import java.util.Arrays;


public class RotaryLock {


    @Test
    public void test(){
//        System.out.println(getMinCodeEntryTime(3,3,new int[]{1,2,3}));

//        System.out.println(from(1,2, 10));
//        System.out.println(from(1,1, 10));
//        System.out.println(from(1,9, 10));

        System.out.println(getMinCodeEntryTime(10,4,new int[]{9,4,4,8}));
    }


    public long getMinCodeEntryTime(int N, int M, int[] C) {
        // Write your code here
        int previous = 1;
        long ret = 0;
        for(int i : C){

            ret += from(previous, i, M);
            previous = i;
        }


        return ret;
    }

    private long from(int previous, int to, int m) {
        return Math.min(Math.abs(to - previous), Math.abs(Math.min(previous, to) + m - Math.max(previous, to)));
    }



    public int getMinProblemCount(int N, int[] S) {
        // Write your code here

        int max = 0;
        boolean odd = false;
        for (int i : S) {
            max = Math.max(i, max);
            if(!odd){
                odd = i%2 == 1;
            }
        }

        return odd ? max/2 + 1 : max/2;
    }

}
