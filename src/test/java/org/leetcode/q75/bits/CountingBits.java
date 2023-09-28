package org.leetcode.q75.bits;

public class CountingBits {

    /**
     * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
     * ans[i] is the number of 1's in the binary representation of i.
     *
     * @param n
     * @return
     */

    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ret[i] = Integer.bitCount(i);
        }
        return ret;
    }
}
