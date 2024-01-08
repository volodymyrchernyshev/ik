package org.leetcode.q75.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MaximumNumberofVowelsInaSubstringofGivenLength {
    /**
     * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
     *
     * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
     */

    @Test
    public void test(){
        Assertions.assertEquals(3, maxVowels("abciiidef", 3));
    }

    public int maxVowels(String s, int k) {

        Set<Character> wovels = new HashSet<>();
        wovels.add('a');
        wovels.add('e');
        wovels.add('i');
        wovels.add('o');
        wovels.add('u');

        int count = 0;
        for(int i = 0; i < k; i++){
            if(wovels.contains(s.charAt(i))) {
                count++;
            }
        }

        int max = count;
        for(int i = k; i < s.length(); i++){

            if(wovels.contains(s.charAt(i))) {
                count++;
            }

            if(wovels.contains(s.charAt(i-k))){
                count--;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
