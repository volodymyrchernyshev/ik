package org.ik.recursion;

import org.junit.jupiter.api.Test;

public class CalculatePower {

    @Test
    public void test(){
        System.out.println(calculate_power(2L, 10L));
    }

    static Integer calculate_power(Long a, Long b) {

        return (int) (power(a, b));
    }

    private static long power(long a, long b) {
        if(b == 0){
            return 1;
        }

        int mod = 1000000007;
        if(b == 1){
            return a % mod;
        }

        a = a % mod;
        long halfPower = calculate_power(a, b /2);

        long ret = (halfPower * halfPower) % mod;
        if(b %2 == 1){
            return (ret * a) % mod;
        }

        return ret;

    }


//        static Integer calculate_power(Long a, Long b) {
//        // Write your code here.
//        long result = helper (a, b);
//        return (int)result;
//    }
//
//    public static long power(long a, long b){
//        //base
//        if (b==0) {
//            return 1;
//        }
//
//        a = a % 1000000007;
//        long half = power (a, b/2);
//        result = (half * half) % 1000000007;
//        if(b%2 == 1){
//             return (result * a) % 1000000007;
//        }
//        return result;
//    }
}
