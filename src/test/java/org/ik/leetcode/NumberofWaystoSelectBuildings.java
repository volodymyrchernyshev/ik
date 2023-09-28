package org.ik.leetcode;

import org.junit.jupiter.api.Test;

public class NumberofWaystoSelectBuildings {


    @Test
    public void test(){
        Arr
        System.out.println(numberOfWays("001101"));
    }

    public long numberOfWays(String s) {
        long ret = 0;

        int zeroCount = 0;
        int oneCount = 0;

        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(c == '0'){
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        int zeroBefore = 0;

        //counting 010
        for(char c : charArray){
            if(c == '0'){
                zeroBefore++;
            } else {
                ret += zeroBefore * (zeroCount - zeroBefore);
            }
        }

        int oneBefore = 0;
        //counting 101
        for(char c : charArray){
            if(c == '0'){
                ret += oneBefore * (oneCount - oneBefore);
            } else {
                oneBefore++;
            }
        }


        return ret;
    }


}
