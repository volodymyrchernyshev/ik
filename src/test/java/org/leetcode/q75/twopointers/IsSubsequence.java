package org.leetcode.q75.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsSubsequence {

    /**
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
     * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence
     * of "abcde" while "aec" is not).
     */

    @Test
    public void test(){
        Assertions.assertTrue(isSubsequence("abc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence("axc", "ahbgdc"));
//        Assertions.assertTrue(isSubsequence("", ""));

    }



    public boolean isSubsequence(String s, String t) {
        int i =0, j =0;
        while(i < s.length() && j< t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }

}
