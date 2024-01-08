package org.leetcode.q75.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemovingStarsFromaString {

    /**
     * You are given a string s, which contains stars *.
     * <p>
     * In one operation, you can:
     * <p>
     * Choose a star in s.
     * Remove the closest non-star character to its left, as well as remove the star itself.
     * Return the string after all stars have been removed.
     * <p>
     * Note:
     * <p>
     * The input will be generated such that the operation is always possible.
     * It can be shown that the resulting string will always be unique.
     */

    @Test
    public void test() {
        Assertions.assertEquals("lecoe", removeStars("leet**cod*e"));
    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (true) {
            return stack.stream().collect(Collector.of(
                    StringBuilder::new,
                    StringBuilder::append,
                    StringBuilder::append,
                    StringBuilder::toString)
            );
        }
        StringBuilder sb = new StringBuilder();


        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
