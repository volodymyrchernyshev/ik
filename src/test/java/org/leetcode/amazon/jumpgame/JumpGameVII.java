package org.leetcode.amazon.jumpgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JumpGameVII {

    /**
     * You are given a 0-indexed binary string s and two integers minJump and maxJump.
     * In the beginning, you are standing at index 0, which is equal to '0'.
     * You can move from index i to index j if the following conditions are fulfilled:
     *
     * i + minJump <= j <= min(i + maxJump, s.length - 1), and
     * s[j] == '0'.
     * Return true if you can reach index s.length - 1 in s, or false otherwise.
     */

    @Test
    public void test(){
        Assertions.assertTrue(canReach("011010", 2 , 3));
        Assertions.assertFalse(canReach("01101110", 2 , 3));
        Assertions.assertTrue(canReach("01111111011110", 1 , 9));
        Assertions.assertFalse(canReach("00111010", 3 , 5));


    }

//    public boolean canReach(String s, int minJump, int maxJump) {
//        if(s.charAt(s.length() -1) != '0'){
//            return false;
//        }
//        List<Integer> zeros = new ArrayList<>();
//        for(int i = 1; i < s.length(); i++) {
//            if(s.charAt(i) == '0'){
//                zeros.add(i);
//            }
//        }
//
//        List<Integer> goodZeros = new ArrayList<>();
//        goodZeros.add(0);
//        int lastGoodIdex = 0;
//        int lastGoodValue = 0;
//        for(int i = 1; i < zeros.size(); i++){
//            Integer index = zeros.get(i);
//            if(){
//
//            }
//        }
//
//    }

    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];

        dp[0] = true;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            if(dp[i]){
                int start = Math.max(i + minJump, end + 1);
                end = Math.min(s.length() -1, i + maxJump);
                for(int j = start; j < s.length() && j <= i+maxJump; j++){
                    if(s.charAt(j) == '0'){
                        dp[j] = true;
                    }
                }
                if(dp[s.length() -1]){
                    return true;
                }
            }
        }

        return dp[s.length() -1];
    }
}
