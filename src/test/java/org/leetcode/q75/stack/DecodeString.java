package org.leetcode.q75.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DecodeString {

    /**
     * Given an encoded string, return its decoded string.
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
     * exactly k times. Note that k is guaranteed to be a positive integer.
     * You may assume that the input string is always valid; there are no extra white spaces,
     * square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain
     * any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
     * The test cases are generated so that the length of the output will never exceed 105.
     */

    @Test
    public void test(){
        Assertions.assertEquals("accaccacc", decodeString2("3[a2[c]]"));
    }


    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> decodedString = new ArrayList<>();
                // get the encoded string
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                // pop [ from the stack
                stack.pop();
                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                // decode k[decodedString], by pushing decodedString k times into stack
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
            // push the current character to stack
            else {
                stack.push(s.charAt(i));
            }
        }
        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }

    public String decodeString2(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                List<Character> decodedString = new ArrayList<>();
                while ((c = stack.pop()) != '[') {
                    decodedString.add(c);
                }

                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k += (stack.pop() - '0') * base;
                    base *= 10;
                }
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
        }
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);

    }

//    public String decodeString(String s) {
//        Stack<StringBuilder> stringStack = new Stack<>();
//        Stack<Character> stack = new Stack<>();
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(c != ']'){
//                stack.push(c);
//            } else {
//                StringBuilder sub = new StringBuilder();
//                int k = 0;
//                while((c = stack.pop()) != '['){
//                    sub.append(c);
//                }
//                while(Character.isDigit(stack.peek())){
//                    if(k != 0){
//                        k *= 10;
//                    }
//                    k += Integer.parseInt(String.valueOf(stack.pop()));
//                }
//                if(sub.length() != 0){
//                    sub = stringStack.pop();
//                }
//
//                int right = sub.length() -1;
//                for(int j = 0 ; j < k; j++){
//                    sub.append(sub, 0, right);
//                }
//                stringStack.push(sub);
//            }
//        }
//
//
//
//        return stringStack.stream().collect(Collectors.joining());
//    }


//    public String decodeString(String s) {
//        StringBuilder ret = new StringBuilder();
//
//        StringBuilder sub = new StringBuilder();
//        int k = 0;
//
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(Character.isDigit(c)){
//                if(k != 0){
//                    k*=10;
//                }
//                k += Integer.parseInt(String.valueOf(c));
//            } else if(Character.isLetter(c)){
//                sub.append(c);
//            } else if(c == '['){
//                sub = new StringBuilder();
//            } else if(c == ']'){
//                for(int j = 0; j < k; j++){
//                    ret.append(sub);
//                }
//                k = 0;
//            } else {
//                //error
//            }
//        }
//        return ret.toString();
//    }
}
