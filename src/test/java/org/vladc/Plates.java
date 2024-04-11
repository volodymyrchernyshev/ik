package org.vladc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Plates {


    @Test
    public void test(){
        System.out.println(getMaxAdditionalDinersCount(15, 2, 3, new long[]{11, 6, 14}));
    }

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here

        Arrays.sort(S);
        long ret = 0;

        long start = 1;
        for(int i = 0; i < S.length; i++){
            long current = S[i];
            if(current - start > (K+1)){
                if(start == 1){
                    ret += (current - start)/(K+1);
                } else {
                    ret += (current - start -K - 1)/(K+1);
                }
            }
            start = current;
        }
        if(start == 1){
            ret += (N - start)/(K+1);
        } else if(N - start > (K+1)){
            ret += (N - start)/(K+1);
        }

        return ret;
    }
}
