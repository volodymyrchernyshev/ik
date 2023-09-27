package org.ik.dynamic.classproblems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {

    @Test
    public void test(){
        System.out.println(word_break("helloworldhello", new ArrayList<>(Arrays.asList("world", "hello", "faang"))));
    }

    static Boolean word_break(String s, ArrayList<String> words_dictionary) {
        // Write your code here.
        if(s == null || s.isEmpty()){
            return true;
        }
        for (String word : words_dictionary) {
            if(s.startsWith(word)){
               String rest = s.substring(word.length());
               if(word_break(rest, words_dictionary)){
                   return true;
               }
            }
        }
        return false;
    }

}
