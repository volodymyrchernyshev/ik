package org.leetcode.amazon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LongestRepeating {


    @Test
    public void test(){
        System.out.println(new LongestRepeating().characterReplacement("ABAB", 2));
    }
    public int characterReplacement(String s, int k) {

        List<int[]> substrings = new ArrayList<>();

        char last = 'a';
        char count = 0;
        for(char c : s.toCharArray()){
            if(last == c){
                count ++;
            } else {
                if(count > 0) {
                    substrings.add(new int[]{last, count});
                }
                last = c;
                count = 1;
            }
        }

        if(count > 0) {
            substrings.add(new int[]{last, count});
        }

        int ret = 0;

        for(int i = 0; i < substrings.size(); i++){
            int current = substrings.get(i)[1];
            int currentC = substrings.get(i)[0];
            int currentK = k;
            for(int j = i+1; j < substrings.size() && currentK >=0; j++){
                if(substrings.get(j)[0] != currentC) {
                    currentK -= substrings.get(j)[1];
                }
                if(currentK >= 0){
                    current += substrings.get(j)[1];;
                }
            }
            ret = Math.max(ret, current);
        }
        return ret;

    }

}
