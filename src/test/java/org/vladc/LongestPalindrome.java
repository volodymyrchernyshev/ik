package org.vladc;

import org.junit.Test;

public class LongestPalindrome {


    @Test
    public void test() {
        System.out.println(this.longestPalindrome("abacabd", true));
        System.out.println(this.longestPalindrome("abacabd", false));
    }

    public String longestPalindrome(String s, boolean isLinear) {
        int n = s.length();
        char[] newStr = new char[2 * n + 1];
        int i = 0;
        newStr[i++] = '#';
        for (char c : s.toCharArray()) {
            newStr[i++] = c;
            newStr[i++] = '#';
        }

        int p[] = new int[2 * n + 1];
        int center = 0, right = 0;

        int longestLength = 0, longestCenter = 0;

        for (i = 0; i < newStr.length; i++) {

            if (isLinear) {//mirroring min value from previous palindrome
                int mirror = 2 * center - i;
                if (right > i) {
                    p[i] = Math.min(p[mirror], right - i);
                }
            }

            {//main logic
                {//checking palindrome
                    int a = i + (p[i] + 1);
                    int b = i - (p[i] + 1);
//                int a = i + 1;
//                int b = i - 1;

                    while (b >= 0 && a < newStr.length && newStr[a] == newStr[b]) {
                        b--;
                        a++;
                        p[i]++;
                    }
                }

                {//checking longest
                    if (p[i] >= longestLength) {
                        longestCenter = i;
                        longestLength = p[i];
                    }
                }
            }

            if (isLinear) {//moving forward the center and right(radius)
                if (i + p[i] > right) {
                    center = i;
                    right = i + p[i];
                }
            }
        }

        String st = new String(newStr);
        return st.substring(longestCenter - longestLength, longestCenter + longestLength).replace("#", "");
    }


}
