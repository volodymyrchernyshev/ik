package org.leetcode.amazon;

import org.junit.jupiter.api.Test;

public class Test3 {


    @Test
    public void test(){
        System.out.println(new Test3().findNthDigit(10));
        System.out.println(new Test3().findNthDigit(11));
    }

    public int findNthDigit(int n) {

        int count = 0;
        for(int i = 1 ; i <= n; i++){
            String s = String.valueOf(i);
            count += s.length();
            //s='12345'
            //n = 10
            //count = 10;
            if(count == n){
                return s.charAt(s.length() -1) - '0';
            }
            if(count >= n){
                return s.charAt(s.length() - (count - n) -1 ) - '0';

            }
        }
        return -1;
    }


}
