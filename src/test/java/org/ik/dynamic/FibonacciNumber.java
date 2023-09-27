package org.ik.dynamic;

public class FibonacciNumber {



    static Integer find_fibonacci(Integer n) {
        // Write your code here.
        if(n <= 0){
            return 0;
        } else if(n == 1){
            return 1;
        } else if(n == 2){
            return 2;
        }

        int a = 1;
        int b = 1;
        int ret = 0;
        for(int i = 1; i < n; i++){
            ret = a + b;
            a = b;
            b = ret;
        }
        return ret;
    }


}
