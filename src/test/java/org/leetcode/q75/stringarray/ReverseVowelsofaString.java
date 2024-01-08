package org.leetcode.q75.stringarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {

    /**
     * Given a string s, reverse only all the vowels in the string and return it.
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     */

    @Test
    public void test(){
//        Assertions.assertEquals("holle", reverseVowels("hello"));
//        Assertions.assertEquals("leotcede", reverseVowels("leetcode"));
        Assertions.assertEquals("Aa", reverseVowels("aA"));
    }


    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] array = s.toCharArray();
        for(int i = 0, j = array.length -1; i < j; ){
            boolean iVowel = vowels.contains(array[i]);
            if(!iVowel){
                i++;
            }
            boolean jVowel = vowels.contains(array[j]);
            if(!jVowel){
                j--;
            }
            if(iVowel && jVowel){
                char c = array[i];
                array[i] = array[j];
                array[j] = c;
                i++;
                j--;
            }
        }
        return String.valueOf(array);
    }

}

