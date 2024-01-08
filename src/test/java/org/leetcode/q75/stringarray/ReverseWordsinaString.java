package org.leetcode.q75.stringarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ReverseWordsinaString {

    /**
     * Given an input string s, reverse the order of the words.
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     * Return a string of the words in reverse order concatenated by a single space.
     * Note that s may contain leading or trailing spaces or multiple spaces between two words.
     * The returned string should only have a single space separating the words. Do not include any extra spaces.
     */


    @Test
    public void test(){
        Assertions.assertEquals("blue is sky the", reverseWords("the sky is blue"));
        Assertions.assertEquals("world hello", reverseWords("  hello world  "));
    }

    public String reverseWords(String s) {

        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = splits.length -1; i >= 0; i--){
            if(!splits[i].isEmpty()){
                sb.append(splits[i]);
                sb.append(" ");
            }
        }

        if(sb.length() > 0){
            sb.delete(sb.length() -1, sb.length());
        }
        return sb.toString();
    }


}
