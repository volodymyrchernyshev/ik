package org.leetcode.q75.stringarray;

public class StringCompression {

    /**
     * Given an array of characters chars, compress it using the following algorithm:
     *
     * Begin with an empty string s. For each group of consecutive repeating characters in chars:
     *
     * If the group's length is 1, append the character to s.
     * Otherwise, append the character followed by the group's length.
     * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
     * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
     *
     * After you are done modifying the input array, return the new length of the array.
     *
     * You must write an algorithm that uses only constant extra space.
     */



    public int compress(char[] chars) {
        int ret = 0;
        char previous = chars[0];
        int count = 1;

        for(int i = 1; i < chars.length; i++){
            if(previous != chars[i]){
                if(count == 1){
                    chars[ret++] = previous;
                } else {
                    chars[ret++] = previous;
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[ret++] = c;
                    }
                }
                previous = chars[i];
                count = 1;
            } else {
                count++;
            }
        }

        chars[ret++] = previous;
        if(count >1){
            for (char c : String.valueOf(count).toCharArray()) {
                chars[ret++] = c;
            }
        }

        return ret;
    }


}
