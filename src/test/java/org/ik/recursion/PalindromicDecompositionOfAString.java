package org.ik.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PalindromicDecompositionOfAString {

    @Test
    public void test() {
        System.out.println(generate_palindromic_decompositions("abracadabra"));
    }


    static ArrayList<String> generate_palindromic_decompositions(String s) {
        // Write your code here.

        return generateStrings(s, 0);
    }

    private static ArrayList<String> generateStrings(String s, int start) {
        ArrayList<String> ret = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                if (isPalindrom(s, i, j)) {
                    ret.add(s.substring(i, j));
                }
            }
        }
        return ret;
    }

    private static boolean isPalindrom(String s, int l, int r) {
        r--;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}
