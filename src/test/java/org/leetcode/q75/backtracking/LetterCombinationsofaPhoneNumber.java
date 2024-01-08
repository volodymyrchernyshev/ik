package org.leetcode.q75.backtracking;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
     * that the number could represent. Return the answer in any order.
     * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     */

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return Collections.emptyList();
        }
        Map<Character, char[]> keyboard = new HashMap<>();
        keyboard.put('2', "abc".toCharArray());
        keyboard.put('3', "def".toCharArray());
        keyboard.put('4', "ghi".toCharArray());
        keyboard.put('5', "jkl".toCharArray());
        keyboard.put('6', "mno".toCharArray());
        keyboard.put('7', "pqrs".toCharArray());
        keyboard.put('8', "tuv".toCharArray());
        keyboard.put('9', "wxyz".toCharArray());

        List<String> ret = new ArrayList<>();
        letterCombinations(digits, 0, ret, keyboard, new StringBuilder());
        return ret;
    }

    private void letterCombinations(String digits, int i, List<String> ret, Map<Character, char[]> keyboard, StringBuilder sb) {
        if(i >= digits.length()){
            ret.add(sb.toString());
            return;
        }
        for (char c : keyboard.get(digits.charAt(i))) {
            sb.append(c);
            letterCombinations(digits, i + 1, ret, keyboard, new StringBuilder());
            sb.deleteCharAt(      sb.length() -1);
        }
    }

}
