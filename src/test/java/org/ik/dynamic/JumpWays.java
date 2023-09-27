package org.ik.dynamic;

public class JumpWays {


    static Long jump_ways(Integer n) {
        // Write your code here.
        if(n <= 0){
            return 0L;
        } else if(n == 1){
            return 1L;
        } else if(n == 2){
            return 2L;
        }

        long a = 1;
        long b = 1;
        long ret = 0;
        for(int i = 1; i < n; i++){
            ret = a + b;
            a = b;
            b = ret;
        }
        return ret;
    }

}
