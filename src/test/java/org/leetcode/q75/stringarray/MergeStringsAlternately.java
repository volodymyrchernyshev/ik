package org.leetcode.q75.stringarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeStringsAlternately {

    /**
     * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
     * starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
     * <p>
     * Return the merged string.
     */

    @Test
    public void test() {
        Assertions.assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
        Assertions.assertEquals("apbqcr", mergeAlternatelyFaster("abc", "pqr"));
    }


    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < word1.length() || j < word2.length(); i++, j++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (j < word2.length()) {
                sb.append(word2.charAt(j));
            }
        }
        return sb.toString();
    }

    public String mergeAlternatelyFaster(String word1, String word2) {
        StringBuilder ret = new StringBuilder();
        int min = Math.min(word1.length(), word2.length());
        for (int i = 0; i < min; i++) {
            ret.append(word1.charAt(i));
            ret.append(word2.charAt(i));
        }

        if (word1.length() > min) {
            ret.append(word1.substring(min));
        } else if (word2.length() > min) {
            ret.append(word2.substring(min));
        }

        return ret.toString();
    }
}
